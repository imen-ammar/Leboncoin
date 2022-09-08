package com.appli.leboncoin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_annonce")
	@SequenceGenerator(name = "seq_annonce", allocationSize = 1)
	private int id;
	private String titre;
	private String description;
	private double prix;
	private Date datePublication;

	@ManyToOne
	@JoinColumn(name="id_utilisateur", nullable=false)
	// pour ne pas aller chercher les informations d'un utilisateur en lecture
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
	private List<Message> messages = new ArrayList<>();

	public Annonce() {
	}

	public Annonce(String titre, String description, double prix, Date datePublication) {
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.datePublication = datePublication;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
