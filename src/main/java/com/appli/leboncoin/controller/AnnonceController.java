package com.appli.leboncoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appli.leboncoin.entity.Annonce;
import com.appli.leboncoin.service.AnnonceService;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;

	@GetMapping
	public Annonce getAnnonce(@RequestParam int id) {
		return annonceService.recupererAnnonce(id);
	}
	
	@GetMapping("/utilisateur")
	public List<Annonce> getAnnoncesByUtilisateur(@RequestParam int id) {
		return annonceService.recupererAnnoncesByIdUtilisateur(id);
	}
	
	@GetMapping("/prix")
	public List<Annonce> getAnnoncesByUtilisateur(@RequestParam double prix) {
		return annonceService.recupererAnnoncesByPrix(prix);
	}

	@PostMapping("/save")
	public Annonce sauvegarderAnnonce(@RequestBody Annonce annonce) {
		return annonceService.sauvegarderAnnonce(annonce);
	}

	@PutMapping("/put")
	public Annonce modifierAnnonce(@RequestBody Annonce annonce) {
		return annonceService.modifierAnnonce(annonce);
	}

	@DeleteMapping
	public void supprimerAnnonce(@RequestParam int id) {
		annonceService.supprimerAnnonce(id);
	}

}
