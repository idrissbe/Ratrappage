package com.todolist.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.interf.ListeTacheDAOInterf;
import com.todolist.entities.ListeTache;
import com.todolist.metier.interf.ListeTacheMetierInterf;

@Transactional
public class ListeTacheMetierImpl implements ListeTacheMetierInterf {

	private ListeTacheDAOInterf listeTacheDAO;

	public void setListeTacheDAO(ListeTacheDAOInterf listeTacheDAO) {
		this.listeTacheDAO = listeTacheDAO;
	}

	@Override
	public Integer addListeTache(ListeTache r) {
		// TODO Auto-generated method stub
		return listeTacheDAO.addListeTache(r);
	}

	@Override
	public void updateListeTache(ListeTache r) {
		// TODO Auto-generated method stub
		listeTacheDAO.updateListeTache(r);
	}

	@Override
	public void deleteListeTache(Integer idR) {
		// TODO Auto-generated method stub
		listeTacheDAO.deleteListeTache(idR);
	}

	@Override
	public List<ListeTache> listListeTache() {
		// TODO Auto-generated method stub
		return listeTacheDAO.listListeTache();
	}

	@Override
	public ListeTache getListeTache(Integer idR) {
		// TODO Auto-generated method stub
		return listeTacheDAO.getListeTache(idR);
	}

}
