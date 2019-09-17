package com.todolist.metier.interf;

import java.util.List;

import com.todolist.entities.Utilisateur;

public interface UtilisateurMetierInterf {

	public Integer addUtilisateur(Utilisateur u);

	public void updateUtilisateur(Utilisateur u);

	public void deleteUtilisateur(Integer idU);

	public List<Utilisateur> listUtilisateur();

	public Utilisateur getUtilisateur(Integer idU);

	public String roleUtilisateur(String nom);

	public byte[] makaSary(String nom);

	public Integer matrUtilisateur(String nom);

	
}
