package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.NoteBusiness;
import com.sensors.dao.NoteRepository;
import com.sensors.entities.Note;

@Service
public class NoteImplementation implements NoteBusiness {

	@Autowired
	NoteRepository noteRepository;

	@Override
	public Note saveNote(Note n) {
		// TODO Auto-generated method stub
		return noteRepository.save(n);
	}

	@Override
	public List<Note> noteList() {
		// TODO Auto-generated method stub
		return noteRepository.findAll();
	}

}
