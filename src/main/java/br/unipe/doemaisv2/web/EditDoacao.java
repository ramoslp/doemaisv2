package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.model.Doador;
import br.unipe.doemaisv2.service.CentroRecolhimentoService;
import br.unipe.doemaisv2.service.DoacaoService;
import br.unipe.doemaisv2.service.DoadorService;

public class EditDoacao implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Doador> doadores = new DoadorService().list();
		List<CentroRecolhimento> centros = new CentroRecolhimentoService().list();
		req.setAttribute("doadores", doadores);
		req.setAttribute("centros", centros);
		req.setAttribute("doacao", new DoacaoService().find(Long.parseLong(req.getParameter("id"))));
		
		return "/WEB-INF/jsp/doacoes/edit.jsp";
	}

}