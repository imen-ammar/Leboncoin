package com.appli.leboncoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appli.leboncoin.entity.Utilisateur;
import com.appli.leboncoin.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurService;

	@GetMapping
	public Utilisateur getUtilisateur(@RequestParam int id) {
		return utilisateurService.recupererUtilisateur(id);
	}

	@PostMapping("/save")
	public Utilisateur sauvegarderUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.sauvegarderUtilisateur(utilisateur);
	}

	@PutMapping("/put")
	public Utilisateur modifierUtulisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.modifierUtilisateur(utilisateur);
	}

	@DeleteMapping
	public void supprimerUtilisateur(@RequestParam int id) {
		utilisateurService.supprimerUtilisateur(id);
	}

}
