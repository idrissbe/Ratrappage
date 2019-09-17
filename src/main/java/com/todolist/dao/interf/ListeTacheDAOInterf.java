package com.todolist.dao.interf;

import java.util.List;

import com.todolist.entities.ListeTache;

public interface ListeTacheDAOInterf {
	public Integer addListeTache(ListeTache r);

	public void updateListeTache(ListeTache r);

	public void deleteListeTache(Integer idR);

	public List<ListeTache> listListeTache();

	public ListeTache getListeTache(Integer idR);
}
