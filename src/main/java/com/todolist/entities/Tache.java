package com.todolist.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tache")
public class Tache {

	@Id
	@Column(name = "tacheid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tacheId;
	@Column(name = "tachename", length = 20, nullable = false)
	private String tacheName;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateTache;
	@Column(name = "description")
	private String description;
	@Column(name = "accomplie")
	private boolean accomplie;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tache", cascade = CascadeType.ALL)
	private Set<ListeTache> listetache = new HashSet<ListeTache>(0);

	@Transient
	private String setDateTache;

	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTacheId() {
		return tacheId;
	}

	public void setTacheId(Integer tacheId) {
		this.tacheId = tacheId;
	}

	public String getTacheName() {
		return tacheName;
	}

	public void setTacheName(String tacheName) {
		this.tacheName = tacheName;
	}

	public Date getDateTache() {
		return dateTache;
	}

	public void setDateTache(Date dateTache) {
		this.dateTache = dateTache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAccomplie() {
		return accomplie;
	}

	public void setAccomplie(boolean accomplie) {
		this.accomplie = accomplie;
	}

	public Set<ListeTache> getListetache() {
		return listetache;
	}

	public void setListetache(Set<ListeTache> listetache) {
		this.listetache = listetache;
	}

	public String getSetDateTache() {
		return setDateTache;
	}

	public void setSetDateTache(String setDateTache) {
		this.setDateTache = setDateTache;
	}

	public Tache(String tacheName, Date dateTache, String description, boolean accomplie, String setDateTache) {
		super();
		this.tacheName = tacheName;
		this.dateTache = dateTache;
		this.description = description;
		this.accomplie = accomplie;
		this.setDateTache = setDateTache;
	}

}
