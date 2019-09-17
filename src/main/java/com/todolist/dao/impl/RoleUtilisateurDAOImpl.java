package com.todolist.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.RoleUtilisateurDAOInterf;
import com.todolist.entities.RoleUtilisateur;

@Transactional
public class RoleUtilisateurDAOImpl implements RoleUtilisateurDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addRoleUtilisateur(RoleUtilisateur r) {
		// TODO Auto-generated method stub
		em.persist(r);
		return r.getRoleId();
	}

	@Override
	public void udpateRoleUtilisateur(RoleUtilisateur r) {
		// TODO Auto-generated method stub
		em.merge(r);
	}

	@Override
	public void deleteRoleUtilsiateur(Integer idR) {
		// TODO Auto-generated method stub
		RoleUtilisateur r = getRoleUtilisateur(idR);
		em.remove(r);
	}

	@Override
	public List<RoleUtilisateur> listRoleUtilisateur() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select r from RoleUtilisateur r");
		return req.getResultList();
	}

	@Override
	public RoleUtilisateur getRoleUtilisateur(Integer idR) {
		// TODO Auto-generated method stub
		return em.find(RoleUtilisateur.class, idR);
	}

}
