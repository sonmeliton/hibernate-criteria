package com.son.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "carrera")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrera;
	
	private String nombreCarrera;
	
	@CreationTimestamp
	private Date altaCarrera;
	
	@OneToMany(mappedBy = "carrera")
	private List<Asignatura> asignaturaSet = new ArrayList<>();;
	
	public Carrera() {
		
	}

	public Carrera(String nombreCarrera, Date altaCarrera) {
		this.nombreCarrera = nombreCarrera;
		this.altaCarrera = altaCarrera;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	
	public Date getAltaCarrera() {
		return altaCarrera;
	}

	public void setAltaCarrera(Date altaCarrera) {
		this.altaCarrera = altaCarrera;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombreCarrera=" + nombreCarrera + ", altaCarrera=" + altaCarrera
				+ "]";
	}

}
