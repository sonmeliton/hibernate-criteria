package com.son.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlumno;
	
//	@Column(name="nombreAlumno")
	private String nombreAlumno;
	
	private Date fechaNacimiento;
	
	@OneToOne
	@JoinColumn(name = "IdCarrera")
	private Carrera carrera;
	
	public Alumno() {
		
	}

	public Alumno(String nombreAlumno, Date fechaNacimiento) {
		this.nombreAlumno = nombreAlumno;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombreAlumno=" + nombreAlumno + ", fechaNacimiento="
				+ fechaNacimiento + ", carrera=" + carrera + "]";
	}

}
