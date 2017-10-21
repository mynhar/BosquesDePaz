package org.bosque.model.bean;

import java.sql.Date;

public class Autorizado {

	private Cliente cliente;
    private Persona persona;
    private String parentezco;

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getParentezco() {
		return parentezco;
	}
	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}
}