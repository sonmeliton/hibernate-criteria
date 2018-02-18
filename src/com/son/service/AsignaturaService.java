package com.son.service;

import java.util.List;

import org.hibernate.Session;

import com.son.dao.AsignaturaDaoImpl;
import com.son.domain.Asignatura;

public class AsignaturaService {
	
	private AsignaturaDaoImpl asignaturaDao;

	public AsignaturaService(Session session) {
		asignaturaDao = new AsignaturaDaoImpl(session);
	}
	
	public void save(Asignatura asignatura) {
		asignaturaDao.save(asignatura);
	}
	
	public List<Asignatura> findAll() {
		return asignaturaDao.findAll();
	}
	
	public Asignatura findById(int id){
		return asignaturaDao.findById(id);
	}
	
}
