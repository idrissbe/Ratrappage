package com.todolist.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.UtilisateurDAOInterf;
import com.todolist.entities.Utilisateur;
import com.todolist.metier.interf.UtilisateurMetierInterf;

@Transactional
public class UtilisateurMetierImpl implements UtilisateurMetierInterf {

	private UtilisateurDAOInterf utilisateurDAO;

	public UtilisateurDAOInterf getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(UtilisateurDAOInterf utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public Integer addUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		return utilisateurDAO.addUtilisateur(u);
	}

	@Override
	public void updateUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		utilisateurDAO.updateUtilisateur(u);
	}

	@Override
	public void deleteUtilisateur(Integer idU) {
		// TODO Auto-generated method stub
		utilisateurDAO.deleteUtilisateur(idU);
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return utilisateurDAO.listUtilisatueur();
	}

	@Override
	public Utilisateur getUtilisateur(Integer idU) {
		// TODO Auto-generated method stub
		return utilisateurDAO.getUtilisateur(idU);
	}

	@Override
	public String roleUtilisateur(String nom) {
		// TODO Auto-generated method stub
		return utilisateurDAO.roleUtilisateur(nom);
	}

	@Override
	public byte[] makaSary(String nom) {
		// TODO Auto-generated method stub
		return utilisateurDAO.makaSary(nom);
	}

	@Override
	public Integer matrUtilisateur(String nom) {
		// TODO Auto-generated method stub
		return utilisateurDAO.matrUtilisateur(nom);
	}

}
