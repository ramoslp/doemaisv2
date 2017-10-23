package br.unipe.doemaisv2.service;

import br.unipe.doemaisv2.dao.AbstractDAO;
import br.unipe.doemaisv2.dao.CentroRecolhimentoDAO;
import br.unipe.doemaisv2.model.CentroRecolhimento;

public class CentroRecolhimentoService extends AbstractService<CentroRecolhimento>{

	@Override
	public AbstractDAO<CentroRecolhimento> getDAO() {
		return new CentroRecolhimentoDAO(manager);
	}

	

}