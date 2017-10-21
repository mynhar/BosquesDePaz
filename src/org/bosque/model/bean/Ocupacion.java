package org.bosque.model.bean;

public class Ocupacion {
	private Long ocupacion;
	private String descripcion;

	public Ocupacion() {
	}

	public Long getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(Long ocupacion) {
		this.ocupacion = ocupacion;
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
}