package org.bosque.model.bean;

import java.math.BigDecimal;

public class Placa {

    private Long placa;
    private Factura factura;
    private Cliente cliente;
    private Agente agente;
    private java.util.Date fecSolicitud;
    private java.util.Date fecEntrega;
    private Persona persona;
    private java.util.Date fecNacimiento;
    private java.util.Date fecDefuncion;
    private String adorno;
    private String tamano;
    private String texto;
    private String tipoLetra;
    private Lote lote;
    private BigDecimal costoPlaca;

    public Long getPlaca() {
	return placa;
    }

    public void setPlaca(Long placa) {
	this.placa = placa;
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

    public java.util.Date getFecSolicitud() {
	return fecSolicitud;
    }

    public void setFecSolicitud(java.util.Date fecSolicitud) {
	this.fecSolicitud = fecSolicitud;
    }

    public java.util.Date getFecEntrega() {
	return fecEntrega;
    }

    public void setFecEntrega(java.util.Date fecEntrega) {
	this.fecEntrega = fecEntrega;
    }

    public Persona getPersona() {
	return persona;
    }

    public void setPersona(Persona persona) {
	this.persona = persona;
    }

    public java.util.Date getFecNacimiento() {
	return fecNacimiento;
    }

    public void setFecNacimiento(java.util.Date fecNacimiento) {
	this.fecNacimiento = fecNacimiento;
    }

    public java.util.Date getFecDefuncion() {
	return fecDefuncion;
    }

    public void setFecDefuncion(java.util.Date fecDefuncion) {
	this.fecDefuncion = fecDefuncion;
    }

    public String getAdorno() {
	return adorno;
    }

    public void setAdorno(String adorno) {
	this.adorno = adorno;
    }

    public String getTamano() {
	return tamano;
    }

    public void setTamano(String tamano) {
	this.tamano = tamano;
    }

    public String getTexto() {
	return texto;
    }

    public void setTexto(String texto) {
	this.texto = texto;
    }

    public String getTipoLetra() {
	return tipoLetra;
    }

    public void setTipoLetra(String tipoLetra) {
	this.tipoLetra = tipoLetra;
    }

    public Lote getLote() {
	return lote;
    }

    public void setLote(Lote lote) {
	this.lote = lote;
    }

    public BigDecimal getCostoPlaca() {
	return costoPlaca;
    }

    public void setCostoPlaca(BigDecimal costoPlaca) {
	this.costoPlaca = costoPlaca;
    }
}