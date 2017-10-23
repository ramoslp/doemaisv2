package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.service.CampanhaService;
import br.unipe.doemaisv2.service.CentroRecolhimentoService;

public class EditCampanha implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<CentroRecolhimento> centros = new CentroRecolhimentoService().list();
		req.setAttribute("centros", centros);
		req.setAttribute("campanha", new CampanhaService().find(Long.parseLong(req.getParameter("id"))));
		
		return "/WEB-INF/jsp/campanhas/edit.jsp";
	}

}