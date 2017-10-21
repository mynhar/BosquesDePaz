package org.bosque.model.bean;

public class LoteDetalle {
	private Lote lote;
	private String nicho;
	private Persona persona;
	private java.util.Date fecSuceso;
	private String estadoNicho; 

	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	public String getNicho() {
		return nicho;
	}
	public void setNicho(String nicho) {
		this.nicho = nicho;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public java.util.Date getFecSuceso() {
		return fecSuceso;
	}
	public void setFecSuceso(java.util.Date fecSuceso) {
		this.fecSuceso = fecSuceso;
	}
	public String getEstadoNicho() {
		return estadoNicho;
	}
	public void setEstadoNicho(String estadoNicho) {
		this.estadoNicho = estadoNicho;
	}
}
