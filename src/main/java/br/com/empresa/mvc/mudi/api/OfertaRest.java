package br.com.empresa.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.empresa.mvc.mudi.model.Oferta;
import br.com.empresa.mvc.mudi.model.Pedido;
import br.com.empresa.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRest {
	
	@Autowired
	private PedidoRepository pedidoRepository; 
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {		
		
		Optional<Pedido> pedidoBuscado = this.pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();		
		Oferta novaOferta = requisicao.toOferta();
//		novaOferta.setPedido(pedido);
//		pedido.getOfertas().add(novaOferta);
		pedido.adicionaOferta(novaOferta);
		
		this.pedidoRepository.save(pedido);
		
		return novaOferta;
	}
}
