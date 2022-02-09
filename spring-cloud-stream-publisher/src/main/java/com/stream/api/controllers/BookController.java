package com.stream.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stream.api.model.Book;

@RestController
public class BookController {

	@Autowired
	@Qualifier("output")
	private MessageChannel controlBusChannel;

	@PostMapping("/publish")
	public Book publishEvent(@RequestBody Book book) {
		controlBusChannel.send(MessageBuilder.withPayload(book).build());
		return book;
	}

}
