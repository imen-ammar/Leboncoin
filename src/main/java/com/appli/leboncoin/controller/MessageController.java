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

import com.appli.leboncoin.entity.Message;
import com.appli.leboncoin.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;

	@GetMapping
	public Message getMessage(@RequestParam int id) {
		return messageService.recupererMessage(id);
	}

	@GetMapping("/annonce")
	public List<Message> recupererMessagesByIdAnnonce(@RequestParam int id) {
		return messageService.recupererMessagesByIdAnnonce(id);
	}

	@PostMapping("/save")
	public Message sauvegarderMessage(@RequestBody Message message) {
		return messageService.sauvegarderMessage(message);
	}

	@PutMapping("/put")
	public Message modifierMessage(@RequestBody Message message) {
		return messageService.modifierMessage(message);
	}

	@DeleteMapping
	public void supprimerMessage(@RequestParam int id) {
		messageService.supprimerMessage(id);
	}

}
