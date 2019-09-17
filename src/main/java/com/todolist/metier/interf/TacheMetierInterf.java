package com.todolist.metier.interf;

import java.util.List;

import com.todolist.entities.Tache;

public interface TacheMetierInterf {

	public Integer addTache(Tache e);

	public void udpateTache(Tache e);

	public void deleteTache(Integer idE);

	public List<Tache> listTache();

	public Tache getTache(Integer idE);

}
