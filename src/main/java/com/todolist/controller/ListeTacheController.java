package com.todolist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.entities.ListeTache;
import com.todolist.metier.interf.ListeTacheMetierInterf;
import com.todolist.metier.interf.TacheMetierInterf;
import com.todolist.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/ListeTache")
public class ListeTacheController {

	@Autowired
	private ListeTacheMetierInterf listeTacheMetierInterf;

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;
	@Autowired
	private TacheMetierInterf tacheMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("listetache", new ListeTache());
		model.addAttribute("listetachelist", listeTacheMetierInterf.listListeTache());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "listetachepage";
	}

	@RequestMapping(value = "/saveListeTache")
	public String saveListeTache(@Valid ListeTache listetache, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("listetachelist", listeTacheMetierInterf.listListeTache());
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
			model.addAttribute("tachelist", tacheMetierInterf.listTache());
			return "listetachepage";
		}
		if (listetache.getListeTacheId() != null) {
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
			model.addAttribute("tachelist", tacheMetierInterf.listTache());
			listeTacheMetierInterf.updateListeTache(listetache);
		} else
			listeTacheMetierInterf.addListeTache(listetache);
		model.addAttribute("listetache", new ListeTache());
		model.addAttribute("listetachelist", listeTacheMetierInterf.listListeTache());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "listetachepage";
	}

	@RequestMapping(value = "/editListeTache")
	public String editListeTache(Integer listeTacheId, Model model, HttpServletRequest httpServletRequest) {
		ListeTache listetache = listeTacheMetierInterf.getListeTache(listeTacheId);
		model.addAttribute("listetache", listetache);
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		model.addAttribute("listetachelist", listeTacheMetierInterf.listListeTache());
		return "listetachepage";
	}

	@RequestMapping(value = "/deleteListeTache")
	private String deleteListeTache(Integer listeTacheId, Model model, HttpServletRequest httpServletRequest) {
		listeTacheMetierInterf.deleteListeTache(listeTacheId);
		model.addAttribute("listetache", new ListeTache());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		model.addAttribute("listetachelist", listeTacheMetierInterf.listListeTache());
		return "listetachepage";
	}
}
