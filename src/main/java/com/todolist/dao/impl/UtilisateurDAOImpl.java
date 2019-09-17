package com.todolist.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.UtilisateurDAOInterf;
import com.todolist.entities.Utilisateur;

@Transactional
public class UtilisateurDAOImpl implements UtilisateurDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub

//		Query req = em.createQuery("select e.nom from Employe e where e.employeMatricule = :employeMatricule")
//				.setParameter("employeMatricule", u.getEmploye().getEmployeMatricule());
//
//		Query req1 = em.createQuery("select e.photo from Employe e where e.employeMatricule = :employeMatricule")
//				.setParameter("employeMatricule", u.getEmploye().getEmployeMatricule());

//		Query req2 = em.createQuery("select r.roleName from RoleUtilisateur r where r.roleId = :roleId")
//				.setParameter("roleId", u.getRoleutilisateur().getRoleId());
//		String roleName = (String) req2.getSingleResult();
////		byte[] sary = (byte[]) req1.getSingleResult();
//		u.setRoleName(roleName);
////		String nom = (String) req.getSingleResult();
////		u.setNom(nom);
////		u.setPhoto(sary);
		em.persist(u);
		return u.getUserId();
	}

	@Override
	public void updateUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
//		Query req = em.createQuery("select e.nom from Employe e where e.employeMatricule = :employeMatricule")
//				.setParameter("employeMatricule", u.getEmploye().getEmployeMatricule());
//
//		Query req1 = em.createQuery("select e.photo from Employe e where e.employeMatricule = :employeMatricule")
//				.setParameter("employeMatricule", u.getEmploye().getEmployeMatricule());

//		byte[] sary = (byte[]) req1.getSingleResult();

		Query req2 = em.createQuery("select r.roleName from RoleUtilisateur r where r.roleId = :roleId")
				.setParameter("roleId", u.getRoleutilisateur().getRoleId());
		String roleName = (String) req2.getSingleResult();
//		u.setRoleName(roleName);
//		String nom = (String) req.getSingleResult();
//		u.setNom(nom);
//		u.setMatricule(u.getEmploye().getEmployeMatricule());
//		u.setPhoto(sary);

		em.merge(u);
	}

	@Override
	public void deleteUtilisateur(Integer idU) {
		// TODO Auto-generated method stub
		Utilisateur u = getUtilisateur(idU);
		em.remove(u);
	}

	@Override
	public List<Utilisateur> listUtilisatueur() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public Utilisateur getUtilisateur(Integer idU) {
		// TODO Auto-generated method stub
		return em.find(Utilisateur.class, idU);
	}

	@Override
	public String roleUtilisateur(String nom) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u.roleName from Utilisateur u where u.nom = :nom)").setParameter("nom", nom);
		String anarana = (String) req.getSingleResult();
		return anarana;
	}

	@Override
	public byte[] makaSary(String nom) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u.photo from Utilisateur u where u.userName=:nom").setParameter("nom", nom);
		byte[] sary = (byte[]) req.getSingleResult();
		return sary;
	}

	@Override
	public Integer matrUtilisateur(String nom) {

		// TODO Auto-generated method stub
		Query req = em.createQuery("select u.matricule from Utilisateur u where u.userName= :nom").setParameter("nom",
				nom);
		Integer mat = (Integer) req.getSingleResult();
		return mat;
	}
}