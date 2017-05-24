package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Note;
import com.sensors.implementation.NoteImplementation;

@RestController
public class NoteRestService {

	@Autowired
	NoteImplementation implementation;

	@RequestMapping(value = "/notes", method = RequestMethod.POST)
	public Note saveNote(@RequestBody Note n) {
		return implementation.saveNote(n);
	}

	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public List<Note> noteList() {
		return implementation.noteList();
	}
}
