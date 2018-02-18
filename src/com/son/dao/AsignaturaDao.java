package com.son.dao;

import java.util.List;

import com.son.domain.Asignatura;

public interface AsignaturaDao {
	public void save(Asignatura asignatura);
	public List<Asignatura> findAll();
	public Asignatura findById(int id);
}
