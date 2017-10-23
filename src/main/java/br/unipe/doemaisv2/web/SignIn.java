package br.unipe.doemaisv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignIn implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/jsp/signin.jsp";
	}

}