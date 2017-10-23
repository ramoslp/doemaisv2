package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Campanha;
import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.model.Usuario;
import br.unipe.doemaisv2.service.CampanhaService;

public class AddCampanha implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Campanha campanha = new Campanha();
		Usuario criador = new Usuario();
		CentroRecolhimento local = new CentroRecolhimento();
		
		campanha.setNome(req.getParameter("nome"));
		campanha.setData(req.getParameter("data"));
		
		criador.setLogin(req.getParameter("criador"));
		campanha.setCriador(criador);
		
		local.setId(Long.parseLong(req.getParameter("local")));
		campanha.setLocal(local);
		
		campanha.addObserver(local);
		campanha.addObserver(criador);
		
		campanha.setAprovada(true);
		
		new CampanhaService().save(campanha);
		
		List<Campanha> campanhas = new CampanhaService().list();
		req.setAttribute("campanhas", campanhas);
		
		return "/WEB-INF/jsp/campanhas/list.jsp";
	}
	
}