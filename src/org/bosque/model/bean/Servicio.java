package org.bosque.model.bean;

import java.math.BigDecimal;

public class Servicio {
	private Long servicio;
	private Factura factura;
	private Cliente cliente;
	private Agente agente;
	private Long preSolicitud;
	private Long contrato;
	private Concepto concepto;
	private Persona persona;
	private Lote lote;
	private String nicho;
	private String indTraslado;
	private java.util.Date fecEjecucion;
	private java.util.Date fecContratacion;
	private BigDecimal costoServicio;

	public Long getServicio() {
		return servicio;
	}
	public void setServicio(Long servicio) {
		this.servicio = servicio;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Agente getAgente() {
		return agente;
	}
	public void setAgente(Agente agente) {
		this.agente = agente;
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
	public Concepto getConcepto() {
		return concepto;
	}
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
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
	public String getIndTraslado() {
		return indTraslado;
	}
	public void setIndTraslado(String indTraslado) {
		this.indTraslado = indTraslado;
	}
	public java.util.Date getFecEjecucion() {
		return fecEjecucion;
	}
	public void setFecEjecucion(java.util.Date fecEjecucion) {
		this.fecEjecucion = fecEjecucion;
	}
	public java.util.Date getFecContratacion() {
		return fecContratacion;
	}
	public void setFecContratacion(java.util.Date fecContratacion) {
		this.fecContratacion = fecContratacion;
	}
	public BigDecimal getCostoServicio() {
		return costoServicio;
	}
	public void setCostoServicio(BigDecimal costoServicio) {
		this.costoServicio = costoServicio;
	}
}