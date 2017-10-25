package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Contato;
import br.unipe.doemaisv2.model.Doador;
import br.unipe.doemaisv2.model.Endereco;
import br.unipe.doemaisv2.model.Usuario;
import br.unipe.doemaisv2.service.DoadorService;

public class UpdateDoador implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Doador doador = new DoadorService().find(Long.parseLong(req.getParameter("id")));
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		Usuario usuario = new Usuario();
		
		doador.setNome(req.getParameter("nome"));
		doador.setCpf(req.getParameter("cpf"));
		doador.setDataNascimento(req.getParameter("dataNascimento"));
		doador.setTipoSanguineo(req.getParameter("tipoSanguineo"));
		
		endereco.setCep(req.getParameter("endereco.cep"));
		endereco.setLogradouro(req.getParameter("endereco.logradouro"));
		endereco.setNumero(req.getParameter("endereco.numero"));
		endereco.setComplemento(req.getParameter("endereco.complemento"));
		doador.setEndereco(endereco);
		
		contato.setTelefone(req.getParameter("contato.telefone"));
		contato.setEmail(req.getParameter("contato.email"));
		doador.setContato(contato);
		
		usuario.setLogin(req.getParameter("usuario.login"));
		doador.setUsuario(usuario);
		
		new DoadorService().save(doador);
		
		List<Doador> doadores = new DoadorService().list();
		req.setAttribute("doadores", doadores);
		
		return "/WEB-INF/jsp/doadores/list.jsp";
	}
	
}