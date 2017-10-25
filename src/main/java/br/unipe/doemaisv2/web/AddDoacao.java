package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.model.Doacao;
import br.unipe.doemaisv2.model.Doador;
import br.unipe.doemaisv2.service.DoacaoService;

public class AddDoacao implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Doacao doacao = new Doacao();
		Doador doador = new Doador();
		CentroRecolhimento local = new CentroRecolhimento();
		
		doador.setId(Long.parseLong(req.getParameter("doador")));
		doacao.setDoador(doador);
		
		doacao.setDataDoacao(req.getParameter("dataDoacao"));
		
		local.setId(Long.parseLong(req.getParameter("local")));
		doacao.setLocal(local);
		
		new DoacaoService().save(doacao);
		
		List<Doacao> doacoes = new DoacaoService().list();
		req.setAttribute("doacoes", doacoes);
		
		return "/WEB-INF/jsp/doacoes/list.jsp";
	}
	
}