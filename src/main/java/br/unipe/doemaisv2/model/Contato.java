package br.unipe.doemaisv2.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {

	public String telefone;
	public String email;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}