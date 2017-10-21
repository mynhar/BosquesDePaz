package org.bosque.model.bean;

import java.math.BigDecimal;

public class Recibo {
	private Long recibo;
	private Cliente cliente;
	private Factura factura;
	private java.util.Date fecRecibo;
	private Concepto concepto;
	private String tipoPago;
	private BigDecimal monto;
	private String estadoRecibo;

	public Long getRecibo() {
		return recibo;
	}
	public void setRecibo(Long recibo) {
		this.recibo = recibo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public java.util.Date getFecRecibo() {
		return fecRecibo;
	}
	public void setFecRecibo(java.util.Date fecRecibo) {
		this.fecRecibo = fecRecibo;
	}
	public Concepto getConcepto() {
		return concepto;
	}
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getEstadoRecibo() {
		return estadoRecibo;
	}
	public void setEstadoRecibo(String estadoRecibo) {
		this.estadoRecibo = estadoRecibo;
	}
}
