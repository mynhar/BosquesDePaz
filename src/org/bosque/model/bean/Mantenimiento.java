package org.bosque.model.bean;

import java.math.BigDecimal;

public class Mantenimiento {

	private Long mantenimiento;
	private Factura factura;
	private Cliente cliente;
	private Agente agente;
	private int preSolicitud;
	private int contrato;
	private java.util.Date fecContratacion;
	private java.util.Date fecVence;
	private String diaMesPagar;
	private int mesesGracia;
	private BigDecimal costoMensual;
	private Lote lote;

	public Long getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(Long mantenimiento) {
		this.mantenimiento = mantenimiento;
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
	public int getPreSolicitud() {
		return preSolicitud;
	}
	public void setPreSolicitud(int preSolicitud) {
		this.preSolicitud = preSolicitud;
	}
	public int getContrato() {
		return contrato;
	}
	public void setContrato(int contrato) {
		this.contrato = contrato;
	}
	public java.util.Date getFecContratacion() {
		return fecContratacion;
	}
	public void setFecContratacion(java.util.Date fecContratacion) {
		this.fecContratacion = fecContratacion;
	}
	public java.util.Date getFecVence() {
		return fecVence;
	}
	public void setFecVence(java.util.Date fecVence) {
		this.fecVence = fecVence;
	}
	public String getDiaMesPagar() {
		return diaMesPagar;
	}
	public void setDiaMesPagar(String diaMesPagar) {
		this.diaMesPagar = diaMesPagar;
	}
	public int getMesesGracia() {
		return mesesGracia;
	}
	public void setMesesGracia(int mesesGracia) {
		this.mesesGracia = mesesGracia;
	}
	public BigDecimal getCostoMensual() {
		return costoMensual;
	}
	public void setCostoMensual(BigDecimal costoMensual) {
		this.costoMensual = costoMensual;
	}
	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
}
