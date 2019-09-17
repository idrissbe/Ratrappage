package com.todolist.dao.interf;

import java.util.List;

import com.todolist.entities.RoleUtilisateur;

public interface RoleUtilisateurDAOInterf {

	public Integer addRoleUtilisateur(RoleUtilisateur r);

	public void udpateRoleUtilisateur(RoleUtilisateur r);

	public void deleteRoleUtilsiateur(Integer idR);

	public List<RoleUtilisateur> listRoleUtilisateur();

	public RoleUtilisateur getRoleUtilisateur(Integer idR);
}
