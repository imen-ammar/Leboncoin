package com.appli.leboncoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.leboncoin.entity.Annonce;
import com.appli.leboncoin.repository.AnnonceRepository;

@Service
public class AnnonceService {

	@Autowired
	AnnonceRepository annonceRepository;

	public Annonce recupererAnnonce(int id) {
		return annonceRepository.findById(id).orElse(null);
	}

	public List<Annonce> recupererAnnoncesByIdUtilisateur(int id) {
		return annonceRepository.recupererAnnoncesByIdUtilisateur(id);
	}

	public List<Annonce> recupererAnnoncesByPrix(double prix) {
		return annonceRepository.recupererAnnoncesByPrix(prix);
	}

	public Annonce sauvegarderAnnonce(Annonce annonce) {
		return annonceRepository.save(annonce);
	}

	public Annonce modifierAnnonce(Annonce annonce) {
		Annonce annonceBDD = recupererAnnonce(annonce.getId());
		if (annonceBDD == null) {
			return null;
		}
		return annonceRepository.save(annonce);
	}

	public void supprimerAnnonce(int id) {
		Annonce annonce = recupererAnnonce(id);
		if (annonce != null) {
			annonceRepository.deleteById(id);
		}
	}

}