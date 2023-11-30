package org.ap.model;

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
@Table(name="ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String descripcion;
	@Column
	private String costo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date forden;
	@Column
	private String estado;
	@Column
	private String cliente;
	@Column
	private String categoria;
	@Column
	private String tecnico;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public Date getForden() {
		return forden;
	}
	public void setForden(Date forden) {
		this.forden = forden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
	@Override
	public String toString() {
		return "Orden [id=" + id + ", descripcion=" + descripcion + ", costo=" + costo + ", forden=" + forden
				+ ", estado=" + estado + ", cliente=" + cliente + ", categoria=" + categoria + ", tecnico=" + tecnico
				+ "]";
	}
	
	
	
	
	
}
	
	 
