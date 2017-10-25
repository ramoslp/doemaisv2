package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Usuario;
import br.unipe.doemaisv2.service.UsuarioService;

public class FormDoador implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Usuario> usuarios = new UsuarioService().list();
		req.setAttribute("usuarios", usuarios);
		
		return "/WEB-INF/jsp/doadores/form.jsp";
	}

}