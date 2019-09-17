package com.todolist.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roleutilisateur")
public class RoleUtilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "roleid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	@Column(name = "rolename", nullable = false, length = 30)
	private String roleName;

	@OneToMany(mappedBy = "roleutilisateur", fetch = FetchType.LAZY)
	private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public RoleUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleUtilisateur(String roleName) {
		super();
		this.roleName = roleName;
	}

}