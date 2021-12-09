package by.itacademy.javaenterprise.knyazev.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.itacademy.javaenterprise.knyazev.dao.exceptions.DAOException;
import by.itacademy.javaenterprise.knyazev.entities.Good;

@Repository
public class GoodsDAO implements DAO<Good>{
	private static final Logger logger = LoggerFactory.getLogger(GoodsDAO.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Good good) throws DAOException {
		if (good != null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(good);
				entityManager.getTransaction().commit();
				return good.getId();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				logger.error("Transaction on method int save(Good good) failed: " + e.getMessage()
						+ "with name of class exception: " + e.getClass().getCanonicalName(), e);
				return null;
			}
		} else {
			throw new DAOException(
					"Expected good object. Null was given in method Long save(Good good)");
		}
	}

	@Override
	public Good find(Long id) throws DAOException {

		if (id == null || id < 0L) {
			throw new DAOException(
					"Expected good object. Null or bad ID was given in method Good find(Long id)");
		}

		try {
			return entityManager.find(Good.class, id);
		} catch (IllegalArgumentException e) {
			logger.error("Can't get good object on id=" + id + " on method good find(Integer id): "
					+ e.getMessage() + " with exception class name: " + e.getClass().getCanonicalName(), e);
		}

		return null;
	}

	@Override
	public List<Good> findAll() {

		try {
			return entityManager.createNamedQuery("allGoods", Good.class).getResultList();
		} catch (IllegalStateException | IllegalArgumentException | PersistenceException e) {
			logger.error("Error in method List<Good> findAll(): " + e.getMessage() + " from class exception name: "
					+ e.getClass().getCanonicalName(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public void update(Good good) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(good);
			entityManager.getTransaction().commit();
		} catch (IllegalStateException | IllegalArgumentException | PersistenceException e) {
			entityManager.getTransaction().rollback();
			logger.error("Error in method update(Good good): " + e.getMessage() + " from class exception name: "
					+ e.getClass().getCanonicalName());
			throw new DAOException("Error can't merge object on method void update(Good good)", e);
		}
	}

	@Override
	public void delete(Good good) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(good);
			entityManager.getTransaction().commit();
		} catch (IllegalStateException | IllegalArgumentException | PersistenceException e) {
			entityManager.getTransaction().rollback();
			logger.error("Error in method void delete(Good good): " + e.getMessage()
					+ " from class exception name: " + e.getClass().getCanonicalName());
			throw new DAOException("Error can't remove object on method void delete(Good good)", e);
		}
	}

}
