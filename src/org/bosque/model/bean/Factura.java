package org.bosque.model.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Factura {
	
	private Long idFactura;
	private String tipofactura;//	2		N	VARCHAR2 (2 Byte)		Yes		
	private Cliente cliente;//	3		N	NUMBER		Yes		
	private Agente agente;//	4		Y	NUMBER (2)		Yes		
	private Date fecFactura;//	5		N	DATE		Yes		
	private Long mesesPlazo;//	6		Y	NUMBER (3)		Yes		
	private BigDecimal montoFactura;//	7		N	NUMBER (17,2)		Yes		
	private String estadoFactura;//	8		Y	VARCHAR2 (1 Byte)		Yes
	
	
	/**
	 * @return the idFactura
	 */
	public Long getIdFactura() {
		return idFactura;
	}
	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	/**
	 * @return the tipofactura
	 */
	public String getTipofactura() {
		return tipofactura;
	}
	/**
	 * @param tipofactura the tipofactura to set
	 */
	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the agente
	 */
	public Agente getAgente() {
		return agente;
	}
	/**
	 * @param agente the agente to set
	 */
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	/**
	 * @return the fecFactura
	 */
	public Date getFecFactura() {
		return fecFactura;
	}
	/**
	 * @param fecFactura the fecFactura to set
	 */
	public void setFecFactura(Date fecFactura) {
		this.fecFactura = fecFactura;
	}
	/**
	 * @return the mesesPlazo
	 */
	public Long getMesesPlazo() {
		return mesesPlazo;
	}
	/**
	 * @param mesesPlazo the mesesPlazo to set
	 */
	public void setMesesPlazo(Long mesesPlazo) {
		this.mesesPlazo = mesesPlazo;
	}
	/**
	 * @return the montoFactura
	 */
	public BigDecimal getMontoFactura() {
		return montoFactura;
	}
	/**
	 * @param montoFactura the montoFactura to set
	 */
	public void setMontoFactura(BigDecimal montoFactura) {
		this.montoFactura = montoFactura;
	}
	/**
	 * @return the estadoFactura
	 */
	public String getEstadoFactura() {
		return estadoFactura;
	}
	/**
	 * @param estadoFactura the estadoFactura to set
	 */
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}



	

}
