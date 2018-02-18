package com.son.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrupo;
	
	private String nombreGrupo;
	
	@ManyToMany(mappedBy = "grupos")
	private List<Profesor> profesores = new ArrayList<>();
	
	public Grupo() {
		
	}

	public Grupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombreGrupo=" + nombreGrupo + "]";
	}

}
