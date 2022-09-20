package com.appli.leboncoin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_utilisateur")
	@SequenceGenerator(name = "seq_utilisateur", allocationSize = 1)

	private int id;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;

	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Annonce> annonces = new ArrayList<>();

	@OneToMany(mappedBy = "acheteur", cascade = CascadeType.ALL)
	private List<Message> messages = new ArrayList<>();

	public Utilisateur() {
	}

	public Utilisateur(int id, String nom, String prenom, String telephone, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
