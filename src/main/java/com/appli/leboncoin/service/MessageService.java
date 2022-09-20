package com.appli.leboncoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appli.leboncoin.entity.Message;
import com.appli.leboncoin.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public Message recupererMessage(int id) {
		return messageRepository.findById(id).orElse(null);
	}

	public List<Message> recupererMessagesByIdAnnonce(int id) {
		return messageRepository.recupererMessagesByIdAnnonce(id);
	}

	public Message sauvegarderMessage(Message message) {
		return messageRepository.save(message);
	}

	public Message modifierMessage(Message message) {
		Message messageBdd = recupererMessage(message.getId());
		if (messageBdd == null) {
			return null;
		}

		messageBdd.setDate(message.getDate());
		messageBdd.setText(message.getText());

		return messageRepository.save(messageBdd);
	}

	public void supprimerMessage(int id) {
		Message message = recupererMessage(id);
		if (message != null) {
			messageRepository.deleteById(id);
		}
	}

}
