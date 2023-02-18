package com.party.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.party.dto.EventDTO;
import com.party.exception.PartyException;
import com.party.service.EventService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Validated
public class EventAPI {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	Environment environment;
	
	@PostMapping("/addEvent")
	public ResponseEntity<String> addEvent(@RequestBody EventDTO event) throws PartyException{
		String ret = eventService.addEvent(event);
		return new ResponseEntity<>(ret, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEvent")
	public ResponseEntity<String> updateEvent(@RequestBody EventDTO event) throws PartyException{
		String ret = eventService.updateEvent(event);
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEvent/{eventId}")
	public void deleteEvent(@PathVariable int eventId) throws PartyException {
		eventService.deleteEvent(eventId);
	}
	
	@GetMapping("/getEvent/{eventId}")
	public ResponseEntity<EventDTO> getById(@PathVariable int eventId) throws PartyException {
		EventDTO ret = eventService.getEventById(eventId);
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
	
	@GetMapping("/getEvents")
	public ResponseEntity<List<EventDTO>> getEvents() throws PartyException{
		List<EventDTO> ret = eventService.getEvents();
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
}
