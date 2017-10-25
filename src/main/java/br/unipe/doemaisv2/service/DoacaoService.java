package br.unipe.doemaisv2.service;

import br.unipe.doemaisv2.dao.AbstractDAO;
import br.unipe.doemaisv2.dao.DoacaoDAO;
import br.unipe.doemaisv2.model.Doacao;

public class DoacaoService extends AbstractService<Doacao> {

	@Override
	public AbstractDAO<Doacao> getDAO() {
		return new DoacaoDAO(manager);
	}

}