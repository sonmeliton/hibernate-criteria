package com.son.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.son.domain.Asignatura;
import com.son.domain.Carrera;
import com.son.service.AsignaturaService;
import com.son.util.HibernateUtil;

public class PruebasService {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		AsignaturaService asignaturaService = new AsignaturaService(session);
		
		/*
		Carrera carrera = session.load(Carrera.class, 1);
		Asignatura asignatura = new Asignatura("base de datos avanzadas");
		asignatura.setCarrera(carrera);
		asignaturaService.save( asignatura );*/
		
		/*
		List<Asignatura> asignaturas = asignaturaService.findAll();
		System.out.println(asignaturas);*/
		
		/*
		Asignatura asignatura = asignaturaService.findById(3);
		System.out.println(asignatura);*/
		
	}
	
}
