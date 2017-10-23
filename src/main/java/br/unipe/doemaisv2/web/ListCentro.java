package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.service.CentroRecolhimentoService;

public class ListCentro implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<CentroRecolhimento> centros = new CentroRecolhimentoService().list();
		req.setAttribute("centros", centros);
		
		return "/WEB-INF/jsp/centros/list.jsp";
	}
	
}