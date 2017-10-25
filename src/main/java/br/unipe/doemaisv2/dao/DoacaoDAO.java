package br.unipe.doemaisv2.dao;

import javax.persistence.EntityManager;

import br.unipe.doemaisv2.model.Doacao;

public class DoacaoDAO extends AbstractDAO<Doacao> {

	public DoacaoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Doacao> getEntityClass() {
		return Doacao.class;
	}

}