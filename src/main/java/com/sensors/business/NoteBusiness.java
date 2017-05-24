package com.sensors.business;

import java.util.List;

import com.sensors.entities.Note;


public interface NoteBusiness {
	public Note saveNote(Note n);
	public List<Note> noteList();
	
	
}
