package com.todolist.metier.interf;

import java.util.List;

import com.todolist.entities.RoleUtilisateur;

public interface RoleUtilisateurMetierInterf {
	public Integer addRoleUtilisateur(RoleUtilisateur r);

	public void updateRoleUtilisateur(RoleUtilisateur r);

	public void deleteRoleUtilisateur(Integer idR);

	public List<RoleUtilisateur> listRoleUtilisateur();

	public RoleUtilisateur getRoleUtilisateur(Integer idR);
}
