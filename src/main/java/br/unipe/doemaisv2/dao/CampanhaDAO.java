package br.unipe.doemaisv2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.unipe.doemaisv2.model.Campanha;

@Transactional
public class CampanhaDAO {

	private EntityManager manager;

	public CampanhaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Campanha save(Campanha campanha) {
		if (campanha.getId() == 0) {
			manager.persist(campanha);
			return campanha;
		}
		return manager.merge(campanha);
	}

	public List<Campanha> list() {
		Query query = manager.createQuery("from " + getEntityClass().getName() + " order by datacampanha");

		@SuppressWarnings("unchecked")
		List<Campanha> list = query.getResultList();
		return list;
	}

	public Campanha findById(Long id) {
		return manager.find(getEntityClass(), id);
	}

	public void remove(Campanha campanha) {
		manager.remove(manager.getReference(getEntityClass(), campanha.getId()));
	}

	public void delete(Long id) {
		manager.remove(findById(id));
	}

	public Class<Campanha> getEntityClass() {
		return Campanha.class;
	}

}
