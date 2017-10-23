package br.unipe.doemaisv2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.unipe.doemaisv2.model.Usuario;

public class UsuarioDAO {
	
	private EntityManager manager;
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario findByLoginAndPassword(String login, String senha) {
		List<Usuario> usuarios = 
				manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class)
				.setParameter("login", login)
				.setParameter("senha", senha)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new RuntimeException("Login e/ou Senha incorreto");
		}
		
		return usuarios.get(0);
	}
	
	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> list() {
		return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public void remove(Usuario usuario) {
		manager.remove(manager.getReference(Usuario.class, usuario.getLogin()));
	}
	
	public Class<Usuario> getEntityClass(){
		return Usuario.class;
	}

}