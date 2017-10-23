package br.unipe.doemaisv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unipe.doemaisv2.model.Usuario;
import br.unipe.doemaisv2.service.UsuarioService;

public class Login implements Action {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioService().findByLoginAndPassword(login, senha);
		if(usuario==null) {
			return "WEB-INF/jsp/login_form.jsp";
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
		}
		return "index.jsp";
	}
	
}