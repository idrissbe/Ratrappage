package com.todolist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listetache")
public class ListeTache {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "listtacheid")
	private Integer listeTacheId;
	@Column(name = "listetachename")
	private String listeTacheName;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "tacheId")
	private Tache tache;

	public Integer getListeTacheId() {
		return listeTacheId;
	}

	public void setListeTacheId(Integer listeTacheId) {
		this.listeTacheId = listeTacheId;
	}

	public String getListeTacheName() {
		return listeTacheName;
	}

	public void setListeTacheName(String listeTacheName) {
		this.listeTacheName = listeTacheName;
	}

	public ListeTache() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListeTache(String listeTacheName) {
		super();
		this.listeTacheName = listeTacheName;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	 

}
