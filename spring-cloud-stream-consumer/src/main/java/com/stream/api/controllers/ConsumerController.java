package com.stream.api.controllers;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.api.model.Book;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {

	@GetMapping
	@StreamListener("input")
	public void consumeMessage(Book book) {
		log.info("Consumed Payload ::: " + book);
	}

}
