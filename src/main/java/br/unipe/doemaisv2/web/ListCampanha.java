package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Campanha;
import br.unipe.doemaisv2.service.CampanhaService;

public class ListCampanha implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Campanha> campanhas = new CampanhaService().list();
		req.setAttribute("campanhas", campanhas);
		
		return "/WEB-INF/jsp/campanhas/list.jsp";
	}
	
}