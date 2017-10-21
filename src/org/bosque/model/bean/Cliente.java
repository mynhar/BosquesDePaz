package org.bosque.model.bean;

import java.util.ArrayList;

public class Cliente {

	private Long id;
    private Persona persona;

    private Long preSolicitud;
    private Long contrato;
    private Agente agente;
    private java.util.Date fecAperturaCta;

    private ArrayList<Autorizado> autorizados;

    public Long getId() {
		return id;
	}

	public void setId(Long cliente) {
		this.id = cliente;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long getPreSolicitud() {
		return preSolicitud;
	}

	public void setPreSolicitud(Long preSolicitud) {
		this.preSolicitud = preSolicitud;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public java.util.Date getFecAperturaCta() {
		return fecAperturaCta;
	}

	public void setFecAperturaCta(java.util.Date fecAperturaCta) {
		this.fecAperturaCta = fecAperturaCta;
	}

	public ArrayList<Autorizado> getAutorizados() {
		return autorizados;
	}

	public void setAutorizados(ArrayList<Autorizado> autorizados) {
		this.autorizados = autorizados;
	}
	
	/**
	 * para mostrar en el combo
	 */
	public String toString(){
		return this.persona.getNombreCompleto();
	}
}
