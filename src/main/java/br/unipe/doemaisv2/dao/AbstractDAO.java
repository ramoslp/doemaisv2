package br.unipe.doemaisv2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unipe.doemaisv2.model.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {

	protected EntityManager manager;

	public AbstractDAO(EntityManager manager) {
		this.manager = manager;
	}

	public T save(T entity) {
		if (entity.getId() == 0) {
			manager.persist(entity);
			return entity;
		}
		return manager.merge(entity);
	}

	public List<T> list() {
		Query query = manager.createQuery("from " + getEntityClass().getName());

		@SuppressWarnings("unchecked")
		List<T> list = query.getResultList();
		return list;
	}

	public T findById(Long id) {
		return manager.find(getEntityClass(), id);
	}

	public void remove(T entity) {
		manager.remove(manager.getReference(getEntityClass(), entity.getId()));
	}

	public void delete(Long id) {
		manager.remove(findById(id));
	}

	public abstract Class<T> getEntityClass();
	
}