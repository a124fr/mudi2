package br.com.empresa.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public String home(Model model) {				
		Sort sort = Sort.by("dataEntrega").descending();		
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = this.pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
		  
}
