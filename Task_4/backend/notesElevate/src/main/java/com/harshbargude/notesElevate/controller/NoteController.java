package com.harshbargude.notesElevate.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.harshbargude.notesElevate.Entity.Note;
import com.harshbargude.notesElevate.service.NoteFileStore;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = {"http://localhost:5173"})
public class NoteController {
    private final NoteFileStore store;
    public NoteController(NoteFileStore store) { this.store = store; }

    @GetMapping public List<Note> all() throws IOException { return store.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Note> get(@PathVariable long id) {
        try { return ResponseEntity.ok(store.findById(id)); }
        catch (NoSuchElementException | IOException e) { return ResponseEntity.notFound().build(); }
    }

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note) {
        try { return ResponseEntity.status(HttpStatus.CREATED).body(store.create(note)); }
        catch (IOException e) { return ResponseEntity.status(500).build(); }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable long id, @RequestBody Note note) {
        try { return ResponseEntity.ok(store.update(id, note)); }
        catch (NoSuchElementException e) { return ResponseEntity.notFound().build(); }
        catch (IOException e) { return ResponseEntity.status(500).build(); }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try { store.delete(id); return ResponseEntity.noContent().build(); }
        catch (IOException e) { return ResponseEntity.status(500).build(); }
    }
}
