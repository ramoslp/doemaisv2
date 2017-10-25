package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Doador;
import br.unipe.doemaisv2.service.DoadorService;

public class RemoveDoador implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		new DoadorService().delete(Long.valueOf(req.getParameter("id")));
		
		List<Doador> doadores = new DoadorService().list();
		req.setAttribute("doadores", doadores);
		
		return "/WEB-INF/jsp/doadores/list.jsp";
	}

}