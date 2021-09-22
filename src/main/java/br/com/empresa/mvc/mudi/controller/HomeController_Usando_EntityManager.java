package br.com.empresa.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.empresa.mvc.mudi.model.Pedido;

//@Controller
public class HomeController_Usando_EntityManager {
	
	//@PersistenceContext
	private EntityManager entityManager;
	
	//@GetMapping("/home")
	public String home(Model model) {
		
		List<Pedido> pedidos = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class)
						.getResultList();				
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
