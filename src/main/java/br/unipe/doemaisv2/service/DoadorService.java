package br.unipe.doemaisv2.service;

import br.unipe.doemaisv2.dao.AbstractDAO;
import br.unipe.doemaisv2.dao.DoadorDAO;
import br.unipe.doemaisv2.model.Doador;

public class DoadorService extends AbstractService<Doador> {

	@Override
	public AbstractDAO<Doador> getDAO() {
		return new DoadorDAO(manager);
	}

}