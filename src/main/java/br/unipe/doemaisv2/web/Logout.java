package br.unipe.doemaisv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Action {


	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		return "index.jsp";
	}
	
}