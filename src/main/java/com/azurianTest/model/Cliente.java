package com.azurianTest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idclientes;

@Column
private String nombres;
@Column
private String apellido;
@Column
private String direccion;
@Column
private String email;
@Column
private String telefono;
@Temporal(TemporalType.TIMESTAMP)
private Date  fregistro;
@Temporal(TemporalType.TIMESTAMP)
private  Date factualizacion;

public Long getIdClientes() {
	return idclientes;
}
public void setIdClientes(Long idclientes) {
	this.idclientes = idclientes;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public Date getFregistro() {
	return fregistro;
}
public void setFregistro(Date fregistro) {
	this.fregistro = fregistro;
}

public Date getFactualizacion() {
	return factualizacion;
}
public void setFactualizacion(Date factualizacion) {
	this.factualizacion = factualizacion;
}

@Override
public String toString() {
	return "Clientes [idClientes=" + idclientes + ", nombres=" + nombres + ", apellido=" + apellido + ", direccion="
			+ direccion + ", email=" + email + ", telefono=" + telefono + ", fregistro=" + fregistro + "]";
}


}
