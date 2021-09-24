package br.com.empresa.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.empresa.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private Long pedidoId;
	private String valor;
	private String dataEntrega;
	private String comentario;
	
	private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, FORMATADOR));
		oferta.setValor(new BigDecimal(valor));
		
		return oferta;
	}

}
