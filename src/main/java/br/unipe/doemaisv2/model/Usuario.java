package br.unipe.doemaisv2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.unipe.doemaisv2.util.Observable;
import br.unipe.doemaisv2.util.Observer;

@Entity
public class Usuario implements Observer {

	@Id
	private String login;

	private String senha;

	private boolean isAdmin;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public void update(Observable o) {
		Campanha campanha = (Campanha) o;
		System.out.println("E-mail enviado para Criador: Sua campanha '" + campanha.getNome() + "' foi aprovada!");
	}

}