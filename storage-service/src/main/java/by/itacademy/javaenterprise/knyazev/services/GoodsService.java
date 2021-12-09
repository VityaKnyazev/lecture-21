package by.itacademy.javaenterprise.knyazev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.javaenterprise.knyazev.dao.GoodsDAO;
import by.itacademy.javaenterprise.knyazev.entities.Good;

@Service
public class GoodsService {
	@Autowired
	private final GoodsDAO goodsDAO;
	
	public GoodsService(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public List<Good> showAll() {
		return goodsDAO.findAll();
	}
}
