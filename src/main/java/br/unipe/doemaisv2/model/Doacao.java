package br.unipe.doemaisv2.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Doacao extends AbstractEntity {

	private String dataDoacao;

	@ManyToOne
	private Doador doador;

	@ManyToOne
	private CentroRecolhimento local;

	public String getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public CentroRecolhimento getLocal() {
		return local;
	}

	public void setLocal(CentroRecolhimento local) {
		this.local = local;
	}

}