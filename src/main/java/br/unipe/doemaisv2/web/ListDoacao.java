package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Doacao;
import br.unipe.doemaisv2.service.DoacaoService;

public class ListDoacao implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Doacao> doacoes = new DoacaoService().list();
		req.setAttribute("doacoes", doacoes);
		
		return "/WEB-INF/jsp/doacoes/list.jsp";
	}
	
}