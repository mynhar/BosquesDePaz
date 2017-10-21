package org.bosque.model.bean;

import java.util.ArrayList;

public class Persona {

	private Long persona;
	private String tipoPersona;
	private String identificacion;
	private String razonSocial;
	private String nombreCompleto;
	private String primerApellido;
	private String segundoApellido;
	private String estadoCivil;
	private String direccion;
	private String correoPrincipal;
	private String correoSecundario;
	private String telefHabitacion;
	private String telefOficina;
	private String extOficina;
	private String telefMovil;
	private Ocupacion ocupacion;
	private java.util.Date fecNacimiento;
	private java.util.Date fecDefuncion;
	private String estadoPersona;
	
	public Persona() {
	}

	public Long getPersona() {
		return persona;
	}
	public void setPersona(Long persona) {
		this.persona = persona;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoPrincipal() {
		return correoPrincipal;
	}
	public void setCorreoPrincipal(String correoPrincipal) {
		this.correoPrincipal = correoPrincipal;
	}
	public String getCorreoSecundario() {
		return correoSecundario;
	}
	public void setCorreoSecundario(String correoSecundario) {
		this.correoSecundario = correoSecundario;
	}
	public String getTelefHabitacion() {
		return telefHabitacion;
	}
	public void setTelefHabitacion(String telefHabitacion) {
		this.telefHabitacion = telefHabitacion;
	}
	public String getTelefOficina() {
		return telefOficina;
	}
	public void setTelefOficina(String telefOficina) {
		this.telefOficina = telefOficina;
	}
	public String getExtOficina() {
		return extOficina;
	}
	public void setExtOficina(String extOficina) {
		this.extOficina = extOficina;
	}
	public String getTelefMovil() {
		return telefMovil;
	}
	public void setTelefMovil(String telefMovil) {
		this.telefMovil = telefMovil;
	}
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
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
	public String getEstadoPersona() {
		return estadoPersona;
	}
	public void setEstadoPersona(String estadoPersona) {
		this.estadoPersona = estadoPersona;
	}
	
	/**
	 * para mostrar en el combo
	 */
	public String toString(){
		return this.getNombreCompleto();
	}
}
