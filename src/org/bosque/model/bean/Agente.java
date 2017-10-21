package org.bosque.model.bean;

public class Agente {

	private Long agente;
	private String nombre;

	public Long getAgente() {
		return agente;
	}
	public void setAgente(Long agente) {
		this.agente = agente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return nombre;
	}
}
