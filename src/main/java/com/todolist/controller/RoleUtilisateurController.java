package com.todolist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.entities.RoleUtilisateur;
import com.todolist.metier.interf.RoleUtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/RoleUtilisateur")
public class RoleUtilisateurController {

	@Autowired
	private RoleUtilisateurMetierInterf roleUtilisateurMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("roleutilisateur", new RoleUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "roleutilisateurpage";
	}

	@RequestMapping(value = "/saveRoleUtilisateur")
	public String saveRoleUtilisateur(@Valid RoleUtilisateur roleUtilisateur, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
			return "roleutilisateurpage";
		}
		if (roleUtilisateur.getRoleId() != null)
			roleUtilisateurMetierInterf.updateRoleUtilisateur(roleUtilisateur);
		else
			roleUtilisateurMetierInterf.addRoleUtilisateur(roleUtilisateur);
		model.addAttribute("roleutilisateur", new RoleUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "roleutilisateurpage";
	}

	@RequestMapping(value = "/editRoleUtilisateur")
	public String editRoleUtilisateur(Integer roleId, Model model, HttpServletRequest httpServletRequest) {
		RoleUtilisateur role = roleUtilisateurMetierInterf.getRoleUtilisateur(roleId);
		model.addAttribute("roleutilisateur", role);
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "roleutilisateurpage";
	}

	@RequestMapping(value = "/deleteRoleUtilisateur")
	private String deleteRoleUtilisateur(Integer roleId, Model model, HttpServletRequest httpServletRequest) {
		roleUtilisateurMetierInterf.deleteRoleUtilisateur(roleId);
		model.addAttribute("roleutilisateur", new RoleUtilisateur());
		model.addAttribute("roleutilisateurlist", roleUtilisateurMetierInterf.listRoleUtilisateur());
		return "roleutilisateurpage";
	}

}
