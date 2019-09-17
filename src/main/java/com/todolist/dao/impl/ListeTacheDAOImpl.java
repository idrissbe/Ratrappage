package com.todolist.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.ListeTacheDAOInterf;
import com.todolist.entities.ListeTache;

@Transactional
public class ListeTacheDAOImpl implements ListeTacheDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addListeTache(ListeTache e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e.getListeTacheId();
	}

	@Override
	public void updateListeTache(ListeTache e) {
		// TODO Auto-generated method stub
		em.merge(e);
	}

	@Override
	public void deleteListeTache(Integer idE) {
		// TODO Auto-generated method stub
		ListeTache r = getListeTache(idE);
		em.remove(r);
	}

	@Override
	public List<ListeTache> listListeTache() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select r from ListeTache r");
		return req.getResultList();
	}

	@Override
	public ListeTache getListeTache(Integer idE) {
		// TODO Auto-generated method stub
		return em.find(ListeTache.class, idE);
	}

}
