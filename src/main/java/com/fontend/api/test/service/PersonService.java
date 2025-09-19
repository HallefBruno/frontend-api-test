package com.fontend.api.test.service;

import com.fontend.api.test.model.Person;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonService {
	
	private final RestClient restClient = RestClient.create();
	
	public void save(Person person) {
		ResponseEntity<Void> response = restClient.post()
		.uri("http://localhost:8081/persons")
		.contentType(APPLICATION_JSON)
		.body(person)
		.retrieve()
		.toBodilessEntity();
		
		if(!response.getStatusCode().is2xxSuccessful()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível salvar o registro!");
		}
	}
	
}
