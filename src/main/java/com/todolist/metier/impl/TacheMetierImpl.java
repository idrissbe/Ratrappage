package com.todolist.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.TacheDAOInterf;
import com.todolist.entities.Tache;
import com.todolist.metier.interf.TacheMetierInterf;

@Transactional
public class TacheMetierImpl implements TacheMetierInterf {

	private TacheDAOInterf tacheDAO;

	public void setTacheDAO(TacheDAOInterf tacheDAO) {
		this.tacheDAO = tacheDAO;
	}

	@Override
	public Integer addTache(Tache e) {
		// TODO Auto-generated method stub
		return tacheDAO.addTache(e);
	}

	@Override
	public void udpateTache(Tache e) {
		// TODO Auto-generated method stub
		tacheDAO.udpateTache(e);
	}

	@Override
	public void deleteTache(Integer idE) {
		// TODO Auto-generated method stub
		tacheDAO.deleteTache(idE);
	}

	@Override
	public List<Tache> listTache() {
		// TODO Auto-generated method stub
		return tacheDAO.listTache();
	}

	@Override
	public Tache getTache(Integer idE) {
		// TODO Auto-generated method stub
		return tacheDAO.getTache(idE);
	}

}
