package br.unipe.doemaisv2.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.doemaisv2.model.Usuario;

@WebFilter(urlPatterns="/*")
public class Filtro implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String usuario = getUsuario(req);
		/*System.out.println("ACTION = " + req.getParameter("action"));
		System.out.println("Usuário " + usuario + " acessando a URI " + req.getRequestURI());*/
		
		if(!usuario.equals("admin") && req.getRequestURI().equals("/doemaisv2/executa")) {
			if(req.getParameter("action").equals("Login")
				|| req.getParameter("action").equals("Logout")
				|| req.getParameter("action").equals("ListCampanha")
				|| req.getParameter("action").equals("FormCampanha")
				|| req.getParameter("action").equals("AddCampanha")
				|| req.getParameter("action").equals("ListCentro")) {
				if(usuario.equals("<deslogado>")
						&& (req.getParameter("action").equals("FormCampanha")
						|| req.getParameter("action").equals("AddCampanha"))) {
					req.getRequestDispatcher("/WEB-INF/jsp/signin.jsp").forward(req, resp);
				}
			}else {
				req.getRequestDispatcher("/WEB-INF/jsp/signin.jsp").forward(req, resp);
			}
		}
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario == null) {
			return "<deslogado>";
		}
		
		return usuario.getLogin();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}