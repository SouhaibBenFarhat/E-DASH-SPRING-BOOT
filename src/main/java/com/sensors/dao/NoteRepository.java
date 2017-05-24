package com.sensors.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.entities.Note;

public interface NoteRepository  extends JpaRepository<Note, Long>{

}
