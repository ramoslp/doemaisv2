package br.unipe.doemaisv2.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.unipe.doemaisv2.util.Observable;
import br.unipe.doemaisv2.util.Observer;

@Entity
public class CentroRecolhimento extends AbstractEntity implements Observer {

	private String nome;

	@Embedded
	private Endereco endereco;

	@Embedded
	private Contato contato;

	@OneToMany(mappedBy = "local")
	private List<Doacao> doacoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}

	@Override
	public void update(Observable o) {
		Campanha campanha = (Campanha) o;
		System.out.println("E-mail enviado para CentroRecolhimento: A campanha '" + campanha.getNome()
				+ "' criada pelo usuário '" + campanha.getCriador().getLogin() + "' foi aprovada!");
	}

}