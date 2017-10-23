package br.unipe.doemaisv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.service.CentroRecolhimentoService;

public class EditCentro implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("centro", new CentroRecolhimentoService().find(Long.parseLong(req.getParameter("id"))));
		
		return "/WEB-INF/jsp/centros/edit.jsp";
	}

}