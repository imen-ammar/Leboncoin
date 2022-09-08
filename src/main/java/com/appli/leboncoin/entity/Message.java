package com.appli.leboncoin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message")
	@SequenceGenerator(name = "seq_message", allocationSize = 1)
	private int id;
	private String text;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_annonce", nullable=false)
	// pour ne pas aller chercher les informations d'une Annonce en lecture
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Annonce annonce;
	
	@ManyToOne
	@JoinColumn(name="id_acheteur", nullable=false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Utilisateur acheteur;

	public Message() {
	}

	public Message(String text, Date date) {
		this.text = text;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

}
