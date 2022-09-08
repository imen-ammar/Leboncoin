package com.appli.leboncoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appli.leboncoin.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	@Query("SELECT m FROM Message m WHERE m.annonce.id = :idAnnonce")
	public List<Message> recupererMessagesByIdAnnonce(@Param("idAnnonce") int idAnnonce);

}
