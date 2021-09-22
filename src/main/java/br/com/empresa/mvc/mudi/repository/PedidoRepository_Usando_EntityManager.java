package br.com.empresa.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.empresa.mvc.mudi.model.Pedido;

@Repository
public class PedidoRepository_Usando_EntityManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pedido> recuperarTodosPedidos() {
		return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class)
				.getResultList();		
	}
}
