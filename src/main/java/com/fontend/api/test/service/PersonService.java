package com.fontend.api.test.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	public void getPagePersons(int pageNumber, int pageSize) {
		if(pageSize == 0) pageSize = 10;
		var response = restClient.get()
			.uri("http://localhost:8081/persons/{pageNumber}/{pageSize}", pageNumber, pageSize)
			.retrieve().body(String.class);
		
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
            try {
                PageImpl<Person> myObject = objectMapper.readValue(response, new TypeReference<PageImpl<Person>>() {});
				System.out.println(myObject.getContent());
			} catch (Exception e) {
                e.printStackTrace();
            }
		
		System.out.println(response);
	}
	
}
