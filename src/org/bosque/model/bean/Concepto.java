package org.bosque.model.bean;

public class Concepto {
	private Long concepto;
	private String descripcion;
	private String tipoConcepto;

	public Concepto() {
	}

	public Long getConcepto() {
		return concepto;
	}

	public void setConcepto(Long concepto) {
		this.concepto = concepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return descripcion;
	}

	public String getTipoConcepto() {
		return tipoConcepto;
	}

	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

}