package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.CentroRecolhimento;
import br.unipe.doemaisv2.model.Contato;
import br.unipe.doemaisv2.model.Endereco;
import br.unipe.doemaisv2.service.CentroRecolhimentoService;

public class UpdateCentro implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		CentroRecolhimento centro = new CentroRecolhimentoService().find(Long.parseLong(req.getParameter("id")));
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		
		centro.setNome(req.getParameter("nome"));
		
		endereco.setCep(req.getParameter("endereco.cep"));
		endereco.setLogradouro(req.getParameter("endereco.logradouro"));
		endereco.setNumero(req.getParameter("endereco.numero"));
		endereco.setComplemento(req.getParameter("endereco.complemento"));
		centro.setEndereco(endereco);
		
		contato.setTelefone(req.getParameter("contato.telefone"));
		contato.setEmail(req.getParameter("contato.email"));
		centro.setContato(contato);
		
		new CentroRecolhimentoService().save(centro);
		
		List<CentroRecolhimento> centros = new CentroRecolhimentoService().list();
		req.setAttribute("centros", centros);
		
		return "/WEB-INF/jsp/centros/list.jsp";
	}

}