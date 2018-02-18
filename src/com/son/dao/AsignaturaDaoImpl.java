package com.son.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.son.domain.Asignatura;

public class AsignaturaDaoImpl implements AsignaturaDao {
	
	private Session session;
	
	public AsignaturaDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void save(Asignatura asignatura) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(asignatura);
			
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

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Asignatura> findAll() {
		Transaction tx = null;
		List<Asignatura> asignaturas = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			
			Criteria crit = session.createCriteria(Asignatura.class);
			crit.setMaxResults(50);
			asignaturas = crit.list();
			
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
		return asignaturas;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Asignatura findById(int id) {
		Transaction tx = null;
		Asignatura asignatura = new Asignatura();
		try {
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Asignatura.class);
			criteria.add(Restrictions.eq("idAsignatura", id));
			asignatura = (Asignatura) criteria.uniqueResult();
			
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
		return asignatura;
	}

}
