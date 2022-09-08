package com.appli.leboncoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.leboncoin.entity.Utilisateur;
import com.appli.leboncoin.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	public Utilisateur recupererUtilisateur(int id) {
		return utilisateurRepository.findById(id).orElse(null);
	}

	public Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
		Utilisateur utilisateurBdd = recupererUtilisateur(utilisateur.getId());
		if (utilisateurBdd == null) {
			return null;
		}

		utilisateurBdd.setNom(utilisateur.getNom());
		utilisateurBdd.setPrenom(utilisateur.getPrenom());
		utilisateurBdd.setTelephone(utilisateur.getTelephone());
		utilisateurBdd.setEmail(utilisateur.getEmail());

		return utilisateurRepository.save(utilisateurBdd);
	}

	public void supprimerUtilisateur(int id) {
		Utilisateur utilisateur = recupererUtilisateur(id);
		if (utilisateur != null) {
			utilisateurRepository.deleteById(id);
		}
	}

}