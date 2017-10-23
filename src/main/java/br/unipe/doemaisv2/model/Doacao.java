package br.unipe.doemaisv2.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Doacao extends AbstractEntity {

	@Temporal(TemporalType.DATE)
	private Calendar data;

	@ManyToOne
	private Doador doador;

	@ManyToOne
	private CentroRecolhimento local;

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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