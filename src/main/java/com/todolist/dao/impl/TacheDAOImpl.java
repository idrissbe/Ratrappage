package com.todolist.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.TacheDAOInterf;
import com.todolist.entities.Tache;

@Transactional
public class TacheDAOImpl implements TacheDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addTache(Tache e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e.getTacheId();
	}

	@Override
	public void udpateTache(Tache e) {
		// TODO Auto-generated method stub
		em.merge(e);
	}

	@Override
	public void deleteTache(Integer idE) {
		// TODO Auto-generated method stub
		Tache r = getTache(idE);
		em.remove(r);
	}

	@Override
	public List<Tache> listTache() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select r from Tache r");
		return req.getResultList();
	}

	@Override
	public Tache getTache(Integer idE) {
		// TODO Auto-generated method stub
		return em.find(Tache.class, idE);
	}

}
