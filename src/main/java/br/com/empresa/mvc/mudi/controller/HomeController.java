package br.com.empresa.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.empresa.mvc.mudi.model.Pedido;
import br.com.empresa.mvc.mudi.model.StatusPedido;
import br.com.empresa.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
//	@Autowired(required = true)
	@Autowired
	private PedidoRepository pedidoRepository;
	
//	public HomeController(PedidoRepository repository) {
//		this.repository = repository;
//	}
	
	@GetMapping
	public String home(Model model, Principal principal) {		
		List<Pedido> pedidos = this.pedidoRepository.findByUsuario(principal.getName());		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {		
		List<Pedido> pedidos = this.pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
//	@GetMapping("/home")
//	public ModelAndView home() {
//	    List<Pedido> pedidos = repository.findAll();
//	    ModelAndView mv = new ModelAndView("home");
//	    mv.addObject("pedidos", pedidos);
//	    return mv; 
//	}  
}
