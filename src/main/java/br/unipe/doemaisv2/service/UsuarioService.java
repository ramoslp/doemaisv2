package br.unipe.doemaisv2.service;

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
	
}