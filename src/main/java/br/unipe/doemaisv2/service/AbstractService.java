package br.unipe.doemaisv2.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.doemaisv2.dao.AbstractDAO;
import br.unipe.doemaisv2.model.AbstractEntity;

public abstract class AbstractService<T extends AbstractEntity> {
	
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("doemaisv2");
	EntityManager manager = null;
	
	public void save(T entity) {
		manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			AbstractDAO<T> dao = getDAO();
			dao.save(entity);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}
	
	public List<T> list() {
		List<T> list = new ArrayList<>();
		manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			AbstractDAO<T> dao = getDAO();
			list = dao.list();
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
		return list;
	}
	
	public T find(Long id) {
		T entity = null;
		manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			AbstractDAO<T> dao = getDAO();
			entity = dao.findById(id);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
		return entity;
	}
	
	public void delete(Long id) {
		manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			AbstractDAO<T> dao = getDAO();
			dao.delete(id);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}

	public abstract AbstractDAO<T> getDAO();
	
}