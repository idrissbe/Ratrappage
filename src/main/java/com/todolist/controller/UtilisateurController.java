package com.todolist.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todolist.entities.Utilisateur;
import com.todolist.metier.interf.RoleUtilisateurMetierInterf;
import com.todolist.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/Utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;
	@Autowired
	private RoleUtilisateurMetierInterf roleUtilisateurMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/saveUtilisateur")
	public String saveUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult, Model model,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
			model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
			return "utilisateurpage";
		}
		if (utilisateur.getUserId() != null) {
			utilisateurMetierInterf.updateUtilisateur(utilisateur);
		} else {
			utilisateurMetierInterf.addUtilisateur(utilisateur);
			model.addAttribute("succes", "Utilisateur ajoute");
		}

		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/editUtilisateur")
	public String editUtilisateur(Integer userId, Model model, HttpServletRequest httpServletRequest) {

		Utilisateur u = utilisateurMetierInterf.getUtilisateur(userId);

		model.addAttribute("utilisateur", u);
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/deleteUtilisateur")
	public String deleteUtilisateur(Integer userId, Model model, HttpServletRequest httpServletRequest) {
		utilisateurMetierInterf.deleteUtilisateur(userId);
		model.addAttribute("succes", "Utilisateur Supprime");
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "utilisateurpage";
	}

//	@RequestMapping(value = "/photoUt", produces = MediaType.IMAGE_JPEG_VALUE)
//	@ResponseBody
//	public byte[] photoEmpl(Integer userId) throws IOException {
//		Utilisateur u = utilisateurMetierInterf.getUtilisateur(userId);
//		return IOUtils.toByteArray(new ByteArrayInputStream(u.getPhoto()));
//	}
}
