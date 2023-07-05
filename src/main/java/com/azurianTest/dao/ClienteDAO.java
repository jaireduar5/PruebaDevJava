package com.azurianTest.dao;

import com.azurianTest.model.Cliente;
import com.azurianTest.model.JPAUtil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
public class ClienteDAO {
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public EntityManager getEntity() {
		return entity;
	}
	public void setEntity(EntityManager entity) {
		this.entity = entity;
	}
	//guardo el cliente 
	public void guardarCliente(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		}
	//editar clinete
	public void actualizarCliente(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}
	public Cliente buscarCliente(Long id) {
		Cliente cli= new Cliente();
		cli=entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return cli;
		
	}

	// obtener todos los cliente
		public List<Cliente> obtenerClientes() {
			List<Cliente> listaClientes = new ArrayList<>();
			Query q = entity.createQuery("SELECT c FROM Cliente c");
			listaClientes = q.getResultList();
			return listaClientes;
		}

		/// eliminar cliente
		public void eliminar(Long id) {
			Cliente c = new Cliente();
			c = entity.find(Cliente.class, id);
			entity.getTransaction().begin();
			entity.remove(c);
			entity.getTransaction().commit();
		}
		
		// editar cliente
		public void editar(Cliente cliente) {
			entity.getTransaction().begin();
			entity.merge(cliente);
			entity.getTransaction().commit();
			/// JPAUtil.shutdown();
		}

}
