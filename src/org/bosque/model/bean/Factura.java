package org.bosque.model.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Factura {
	
	private Long idFactura;
	private String tipofactura;
	private Long cliente;
	private Long contrato;
	private Long servicio;
	private Long lote;
	private Date fechaContratacion;
	private Date fechaEjecucion;
	private Date fechaVenta;
	private Date fechaVence;
	private BigDecimal costoServicio;
	private String estado;
	
	
	
	
	/**
	 * @param factura
	 * @param tipofactura
	 * @param cliente
	 * @param contrato
	 * @param servicio
	 * @param lote
	 * @param fechaContratacion
	 * @param fechaEjecucion
	 * @param fechaVenta
	 * @param fechaVence
	 * @param costoServicio
	 * @param estado
	 */
	public Factura(Long factura, String tipofactura, Long cliente, Long contrato, Long servicio, Long lote,
			Date fechaContratacion, Date fechaEjecucion, Date fechaVenta, Date fechaVence, BigDecimal costoServicio,
			String estado) {
		super();
		this.idFactura = factura;
		this.tipofactura = tipofactura;
		this.cliente = cliente;
		this.contrato = contrato;
		this.servicio = servicio;
		this.lote = lote;
		this.fechaContratacion = fechaContratacion;
		this.fechaEjecucion = fechaEjecucion;
		this.fechaVenta = fechaVenta;
		this.fechaVence = fechaVence;
		this.costoServicio = costoServicio;
		this.estado = estado;
	}
	
	/**
	 * 
	 */
	public Factura() {
		// constructor vacio...
	}	
	
	
	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipofactura() {
		return tipofactura;
	}
	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Long getContrato() {
		return contrato;
	}
	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}
	public Long getServicio() {
		return servicio;
	}
	public void setServicio(Long servicio) {
		this.servicio = servicio;
	}
	public Long getLote() {
		return lote;
	}
	public void setLote(Long lote) {
		this.lote = lote;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Date getFechaVence() {
		return fechaVence;
	}
	public void setFechaVence(Date fechaVence) {
		this.fechaVence = fechaVence;
	}
	public BigDecimal getCostoServicio() {
		return costoServicio;
	}
	public void setCostoServicio(BigDecimal costoServicio) {
		this.costoServicio = costoServicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
