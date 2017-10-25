package br.unipe.doemaisv2.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.doemaisv2.dao.UsuarioDAO;
import br.unipe.doemaisv2.model.Usuario;

public class UsuarioService {
	
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("doemaisv2");
	
	public Usuario findByLoginAndPassword(String login, String senha) {
		EntityManager manager = fac.createEntityManager();
		try {
			UsuarioDAO dao = new UsuarioDAO(manager);
			return dao.findByLoginAndPassword(login, senha);
		}finally {
			manager.close();
		}
	}

	public List<Usuario> list() {
		List<Usuario> list = new ArrayList<>();
		EntityManager manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			list = new UsuarioDAO(manager).list();
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
		return list;
	}
	
}