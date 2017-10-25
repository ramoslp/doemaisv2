package br.unipe.doemaisv2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Usuario;
import br.unipe.doemaisv2.service.DoadorService;
import br.unipe.doemaisv2.service.UsuarioService;

public class EditDoador implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Usuario> usuarios = new UsuarioService().list();
		req.setAttribute("usuarios", usuarios);
		req.setAttribute("doador", new DoadorService().find(Long.parseLong(req.getParameter("id"))));
		
		return "/WEB-INF/jsp/doadores/edit.jsp";
	}

}