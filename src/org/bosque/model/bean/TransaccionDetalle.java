package org.bosque.model.bean;

import java.math.BigDecimal;

public class TransaccionDetalle {

    private Long transaccion;
    private String tipoTransaccion;
    private java.util.Date fecAplica;
    private Cliente cliente;
    private String tipoAplica;
    private Long numAplica;
    private BigDecimal montoAplica;

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
    public java.util.Date getFecAplica() {
        return fecAplica;
    }
    public void setFecAplica(java.util.Date fecAplica) {
        this.fecAplica = fecAplica;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getTipoAplica() {
        return tipoAplica;
    }
    public void setTipoAplica(String tipoAplica) {
        this.tipoAplica = tipoAplica;
    }
    public Long getNumAplica() {
        return numAplica;
    }
    public void setNumAplica(Long numAplica) {
        this.numAplica = numAplica;
    }
    public BigDecimal getMontoAplica() {
        return montoAplica;
    }
    public void setMontoAplica(BigDecimal montoAplica) {
        this.montoAplica = montoAplica;
    }
}