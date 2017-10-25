package br.unipe.doemaisv2.dao;

import javax.persistence.EntityManager;

import br.unipe.doemaisv2.model.Doador;

public class DoadorDAO extends AbstractDAO<Doador> {

	public DoadorDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Doador> getEntityClass() {
		return Doador.class;
	}

}