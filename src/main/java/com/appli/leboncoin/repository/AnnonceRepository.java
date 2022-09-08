package com.appli.leboncoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.leboncoin.entity.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{

	@Query("SELECT a FROM Annonce a WHERE a.utilisateur.id = :idUtilisateur")
	public List<Annonce> recupererAnnoncesByIdUtilisateur(@Param("idUtilisateur") int idUtilisateur);
	
	@Query("SELECT a FROM Annonce a WHERE a.prix < :prix")
	public List<Annonce> recupererAnnoncesByPrix(@Param("prix") double prix);
	
}
