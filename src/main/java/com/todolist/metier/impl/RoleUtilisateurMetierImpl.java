package com.todolist.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.RoleUtilisateurDAOInterf;
import com.todolist.entities.RoleUtilisateur;
import com.todolist.metier.interf.RoleUtilisateurMetierInterf;

@Transactional
public class RoleUtilisateurMetierImpl implements RoleUtilisateurMetierInterf {

	private RoleUtilisateurDAOInterf roleUtilisateurDAO;

	public void setRoleUtilisateurDAO(RoleUtilisateurDAOInterf roleUtilisateurDAO) {
		this.roleUtilisateurDAO = roleUtilisateurDAO;
	}

	@Override
	public Integer addRoleUtilisateur(RoleUtilisateur r) {
		// TODO Auto-generated method stub
		return roleUtilisateurDAO.addRoleUtilisateur(r);
	}

	@Override
	public void updateRoleUtilisateur(RoleUtilisateur r) {
		// TODO Auto-generated method stub
		roleUtilisateurDAO.udpateRoleUtilisateur(r);
	}

	@Override
	public void deleteRoleUtilisateur(Integer idR) {
		// TODO Auto-generated method stub
		roleUtilisateurDAO.deleteRoleUtilsiateur(idR);
	}

	@Override
	public List<RoleUtilisateur> listRoleUtilisateur() {
		// TODO Auto-generated method stub
		return roleUtilisateurDAO.listRoleUtilisateur();
	}

	@Override
	public RoleUtilisateur getRoleUtilisateur(Integer idR) {
		// TODO Auto-generated method stub
		return roleUtilisateurDAO.getRoleUtilisateur(idR);
	}

}
