package by.itacademy.javaenterprise.knyazev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import by.itacademy.javaenterprise.knyazev.entities.Good;
import by.itacademy.javaenterprise.knyazev.services.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/goods")
	public String getAll(Model model) {
		List<Good> goods = goodsService.showAll();
		model.addAttribute("goods", goods);
		return "goods";
	}
}