package br.com.empresa.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.mvc.mudi.interceptor.Acesso;
import br.com.empresa.mvc.mudi.interceptor.InterceptadorDeAcessos;

@RestController
@RequestMapping("/api/acessos")
public class AcessoRest {

	@GetMapping
	public List<Acesso> getAcessos() {
		return InterceptadorDeAcessos.acessos;
	}
}
