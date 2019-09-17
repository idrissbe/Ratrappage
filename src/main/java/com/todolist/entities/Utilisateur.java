package com.todolist.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(name = "login")
	private String login;
	@Column(name = "pwd")
	private String pwd;
	@Column(name = "actived")
	private boolean actived;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private Set<ListeTache> listetache = new HashSet<ListeTache>(0);

	@ManyToOne
	@JoinColumn(name = "roleid")
	private RoleUtilisateur roleutilisateur;

	public Integer getUserId() {
		return userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Set<ListeTache> getListetache() {
		return listetache;
	}

	public void setListetache(Set<ListeTache> listetache) {
		this.listetache = listetache;
	}

	public RoleUtilisateur getRoleutilisateur() {
		return roleutilisateur;
	}

	public void setRoleutilisateur(RoleUtilisateur roleutilisateur) {
		this.roleutilisateur = roleutilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String pwd, boolean actived) {
		super();
		this.login = login;
		this.pwd = pwd;
		this.actived = actived;
	}

}