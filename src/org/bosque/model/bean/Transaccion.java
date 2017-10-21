package org.bosque.model.bean;

import java.math.BigDecimal;

public class Transaccion {
	private Long transaccion;
	private String tipoTransaccion;
	private Cliente cliente;
	private Agente agente;
	private java.util.Date fecTransaccion;
	private Long aplicar;
	private java.util.Date vence;
	private BigDecimal monto;
	private BigDecimal saldo;
	private String estadoTransaccion;

	public Long getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(Long transaccion) {
		this.transaccion = transaccion;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
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
	public java.util.Date getFecTransaccion() {
		return fecTransaccion;
	}
	public void setFecTransaccion(java.util.Date fecTransaccion) {
		this.fecTransaccion = fecTransaccion;
	}
	public Long getAplicar() {
		return aplicar;
	}
	public void setAplicar(Long aplicar) {
		this.aplicar = aplicar;
	}
	public java.util.Date getVence() {
		return vence;
	}
	public void setVence(java.util.Date vence) {
		this.vence = vence;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getEstadoTransaccion() {
		return estadoTransaccion;
	}
	public void setEstadoTransaccion(String estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}
}