package br.unipe.doemaisv2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.unipe.doemaisv2.util.Observable;

@Entity
public class Campanha extends Observable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	private String dataCampanha;

	private boolean aprovada;

	@ManyToOne
	private Usuario criador;

	@ManyToOne
	private CentroRecolhimento local;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return dataCampanha;
	}

	public void setData(String data) {
		this.dataCampanha = data;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
		notifyObservers();
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public CentroRecolhimento getLocal() {
		return local;
	}

	public void setLocal(CentroRecolhimento local) {
		this.local = local;
	}

}