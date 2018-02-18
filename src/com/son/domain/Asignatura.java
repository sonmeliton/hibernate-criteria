package com.son.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsignatura;
	
	private String nombreAsignatura;
	
	@ManyToOne
	@JoinColumn(name = "idCarrera")
	private Carrera carrera;
	
	public Asignatura(){
		
	}

	public Asignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Asignatura [idAsignatura=" + idAsignatura + ", nombreAsignatura=" + nombreAsignatura + ", carrera="
				+ carrera + "]";
	}
	
}
