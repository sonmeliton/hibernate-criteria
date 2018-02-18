package com.son.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.son.domain.Alumno;
import com.son.domain.Carrera;
import com.son.domain.Grupo;
import com.son.domain.Profesor;
import com.son.domain.Asignatura;
import com.son.util.HibernateUtil;

public class PruebasDomain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			
			Date fechaActual = new Date();
			DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			/*
			// insert
			Carrera carrera = new Carrera("programacion", fechaActual);
			session.save(carrera);
			
			Alumno alumno = new Alumno( "son", fechaFormato.parse("01/02/1988 13:45:59") );
			alumno.setCarrera(carrera);
			session.save(alumno);*/
			
			/*
			// findBy, insert
			Carrera carrera = session.load(Carrera.class, 1);
			Alumno alumno = new Alumno( "tony", fechaFormato.parse("12/02/1988 14:45:59") );
			alumno.setCarrera(carrera);
			session.save(alumno);*/
			
			/*
			// update
			Alumno alumno = session.load(Alumno.class, 2);
			alumno.setNombreAlumno("tonic");
			session.save(alumno);*/
			
			/*
			// HQL
			@SuppressWarnings("unchecked")
			Query<Carrera> query = session.createQuery("from Carrera where nombreCarrera = :nombreCarrera"); 
			query.setParameter("nombreCarrera", "programacion");
			List<Carrera> carreras = query.getResultList();
			System.out.println(carreras.toString());*/
			
			/*
			// Criteria consulta
			List<Carrera> carreras = new ArrayList<Carrera>();
			Criteria criteria = session.createCriteria(Carrera.class);
			criteria.add(Restrictions.eq("nombreCarrera", "programacion"));
			carreras = criteria.list();
			System.out.println("Carreras " + carreras);
			for (Carrera carrera : carreras) {
				System.out.println("Nombre carrera: " + carrera.getNombreCarrera());
			}*/
			
			/*
			// Criteria consulta
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Carrera> criteria = builder.createQuery(Carrera.class);
			Root<Carrera> root = criteria.from(Carrera.class);
			criteria.select(root)
					.where(builder.equal(root.get("nombreCarrera"), "contabilidad"));
			
			List<Carrera> carrera = session.createQuery(criteria).getResultList();
			System.out.println(carrera.toString());*/
			
			/*
			// Criteria save, update, delete
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Carrera> criteria = builder.createQuery(Carrera.class);
			Root<Carrera> root = criteria.from(Carrera.class);
			criteria.select(root)
					.where(builder.equal(root.get("nombreCarrera"), "conta"));
			
			Carrera carrera = session.createQuery(criteria).getSingleResult();
			carrera.setNombreCarrera("contabilidad");
			carrera.setAltaCarrera(fechaFormato.parse("01/02/1988 13:45:59"));
			session.update(carrera); //saveOrUpdate
			session.delete(carrera);*/
			
			/*
			// Obtener carrera del alumno
			Alumno alumno = session.load(Alumno.class, 2);
			Carrera carrera = alumno.getCarrera();
			System.out.println("Carrera del alumno 2: " + carrera);*/
			
			/*
			// Obtener todos los alumnos con su carrera
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
			Root<Alumno> root = criteria.from(Alumno.class);
			criteria.select(root);
			
			List<Alumno> alumnos = session.createQuery(criteria).getResultList();
			System.out.println("Listado de alumnos" + alumnos);
			for(Alumno alumno2 : alumnos){
				System.out.println("Alumno: " + alumno2);
			}*/
			
			/*
			// save asignaturas
			Asignatura asignatura1 = new Asignatura("introduccion programacion");
			Asignatura asignatura2 = new Asignatura("poo");
			Asignatura asignatura3 = new Asignatura("modelado 3D");
			Asignatura asignatura4 = new Asignatura("texturas 2D");
			
			Carrera carrera1 = session.load(Carrera.class, 1);
			asignatura1.setCarrera(carrera1);
			asignatura2.setCarrera(carrera1);
			
			Carrera carrera2 = session.load(Carrera.class, 2);
			asignatura3.setCarrera(carrera2);
			asignatura4.setCarrera(carrera2);
			
			session.save(asignatura1);
			session.save(asignatura2);
			session.save(asignatura3);
			session.save(asignatura4);*/
			
			/*
			// Obtener todas las asignaturas con su carrera
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Asignatura> criteria = builder.createQuery( Asignatura.class );
			Root<Asignatura> root = criteria.from( Asignatura.class );
			Join<Asignatura, Carrera> join = root.join("carrera");
			criteria.select(root).distinct(true);
			
			List<Asignatura> results = session.createQuery(criteria).getResultList();
			System.out.println("Resultados: " + results.size());
			System.out.println(results);*/
			
			/*
			// Obtener todas las asignaturas con su carrera
			Criteria criteria = session.createCriteria(Asignatura.class);
		    criteria.setFetchMode("Carrera", FetchMode.JOIN);
		    List list = criteria.list();
			System.out.println(list);*/
			
			/*
			// Obtener asignatura poo de la carrera programacion
			Criteria criteria = session.createCriteria(Asignatura.class,"asignatura")
				    .createAlias("asignatura.carrera","carrera")
				    .add(Restrictions.eq("carrera.nombreCarrera", "programacion"))
				    .add(Restrictions.eq("asignatura.nombreAsignatura", "poo"));
			List list = criteria.list();
			System.out.println(list);*/
			
			/*
			// Obtener todas las asignaturas
			Criteria crit = session.createCriteria(Asignatura.class);
			crit.setMaxResults(50);
			List lista = crit.list();
			System.out.println(lista);*/
			
			/*
			// Obtener asignaturas como intro%
			List lista = session.createCriteria(Asignatura.class)
				    .add( Restrictions.like("nombreAsignatura", "intro%") )
				    .list();
			System.out.println(lista);*/
			
			/*
			// Obtener asignaturas como intro% nombre asignatura
			@SuppressWarnings("unchecked")
			List<Asignatura> lista = session.createCriteria(Asignatura.class)
				    .add( Restrictions.like("nombreAsignatura", "intro%") )
				    .list();
			System.out.println(lista);
			for (Asignatura asignatura : lista) {
				System.out.println("Nombre asignatura: " + asignatura.getNombreAsignatura());
			}*/
			
			/*
			// Obtener asignaturas restrictions
			Criteria criteria = session.createCriteria(Asignatura.class);
			criteria.add(Restrictions.eq("nombreAsignatura", "poo"));
			criteria.add(Restrictions.eq("idAsignatura", 2));
			criteria.addOrder(Order.desc("idAsignatura"));
			List lista = criteria.list();
			System.out.println(lista);*/
			
			/*
			// Obtener asignatura 1
			Criteria criteria = session.createCriteria(Asignatura.class);
			criteria.add(Restrictions.eq("idAsignatura", 1));
			List lista = criteria.list();
			System.out.println(lista);*/
			
			/*
			// save n-m
			Profesor ana = new Profesor("ana");
			Profesor samperio = new Profesor("samperio");
			
			Grupo a1 = new Grupo("a1");
			Grupo a2 = new Grupo("a2");
			Grupo c1 = new Grupo("c1");
			Grupo c2 = new Grupo("c2");
			
			ana.getGrupos().add(a1);
			ana.getGrupos().add(a2);
			ana.getGrupos().add(c1);
			ana.getGrupos().add(c2);
			
			samperio.getGrupos().add(c1);
			samperio.getGrupos().add(c2);
			
			session.save(ana);
			session.save(samperio);*/
			
			/*
			// Criteria consulta
			List<Profesor> profesores = new ArrayList<Profesor>();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Profesor.class);
			profesores = criteria.list();
			System.out.println("Profesores " + profesores);
			
			for (Profesor profesor : profesores) {
				System.out.println("Nombre profesor: " + profesor.getNombreProfesor());
			}*/
			
			
			tx.commit();
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
