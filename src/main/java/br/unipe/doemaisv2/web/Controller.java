package br.unipe.doemaisv2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a action");
		}
		action = "br.unipe.doemaisv2.web." + action;
		try {
			Class<?> clazz = Class.forName(action);
			Action instancia = (Action) clazz.newInstance();
			String pagina = instancia.execute(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}