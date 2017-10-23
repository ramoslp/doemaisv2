package br.unipe.doemaisv2.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.doemaisv2.dao.CampanhaDAO;
import br.unipe.doemaisv2.model.Campanha;

public class CampanhaService {

	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("doemaisv2");
	
	public void save(Campanha campanha) {
		EntityManager manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			new CampanhaDAO(manager).save(campanha);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}
	
	public List<Campanha> list() {
		List<Campanha> list = new ArrayList<>();
		EntityManager manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			list = new CampanhaDAO(manager).list();
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
		return list;
	}
	
	public Campanha find(Long id) {
		Campanha campanha = null;
		EntityManager manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			campanha = new CampanhaDAO(manager).findById(id);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
		return campanha;
	}
	
	public void delete(Long id) {
		EntityManager manager = fac.createEntityManager();
		try {
			manager.getTransaction().begin();
			new CampanhaDAO(manager).delete(id);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}

}