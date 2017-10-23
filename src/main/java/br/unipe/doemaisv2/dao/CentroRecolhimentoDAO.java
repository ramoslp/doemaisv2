package br.unipe.doemaisv2.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.unipe.doemaisv2.model.CentroRecolhimento;

@Transactional
public class CentroRecolhimentoDAO extends AbstractDAO<CentroRecolhimento> {

	public CentroRecolhimentoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<CentroRecolhimento> getEntityClass() {
		return CentroRecolhimento.class;
	}

}