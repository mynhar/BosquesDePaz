package org.bosque.model.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Lote {

	private Long lote;
	private String zona;
	private String fila;
	private Long secuencia;
	private String folio;
	private String plano;
	private Date fecVenta;
	private Date fecUltimoPago;
	private BigDecimal costo;
	private BigDecimal saldo;
	private String estadoLote;

	public Long getLote() {
		return lote;
	}
	public void setLote(Long lote) {
		this.lote = lote;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public Long getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public Date getFecVenta() {
		return fecVenta;
	}
	public void setFecVenta(Date fecVenta) {
		this.fecVenta = fecVenta;
	}
	public Date getFecUltimoPago() {
		return fecUltimoPago;
	}
	public void setFecUltimoPago(Date fecUltimoPago) {
		this.fecUltimoPago = fecUltimoPago;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getEstadoLote() {
		return estadoLote;
	}
	public void setEstadoLote(String estadoLote) {
		this.estadoLote = estadoLote;
	}	
	
	/**
	 * para mostrar en el combo
	 */
	public String toString() {
		return this.lote+" - "+this.zona+" - "+this.fila;
		
	}
}
