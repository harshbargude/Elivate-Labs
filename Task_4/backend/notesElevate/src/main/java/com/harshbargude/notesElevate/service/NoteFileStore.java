package com.harshbargude.notesElevate.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshbargude.notesElevate.Entity.Note;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

@Service
public class NoteFileStore {
    private final ObjectMapper mapper;
    private final File file;

    public NoteFileStore(ObjectMapper mapper,
                         @Value("${app.notes.store:./data/notes.json}") String filePath) {
        this.mapper = mapper;
        this.file = new File(filePath);
    }

    @PostConstruct
    void ensureFile() throws IOException {
        if (file.getParentFile() != null) file.getParentFile().mkdirs();
        if (!file.exists()) writeAll(new ArrayList<>());
    }

    public synchronized List<Note> findAll() throws IOException {
        List<Note> list = readAll();
        list.sort(Comparator.comparing(Note::getUpdatedAt).reversed());
        return list;
    }

    public synchronized Note findById(long id) throws IOException {
        return readAll().stream().filter(n -> Objects.equals(n.getId(), id))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    public synchronized Note create(Note payload) throws IOException {
        List<Note> list = readAll();
        long nextId = list.stream().mapToLong(n -> n.getId() == null ? 0 : n.getId()).max().orElse(0) + 1;
        Instant now = Instant.now();
        Note created = new Note(nextId, payload.getTitle(), payload.getContent(), now, now);
        list.add(created);
        writeAll(list);
        return created;
    }

    public synchronized Note update(long id, Note payload) throws IOException {
        List<Note> list = readAll();
        Note existing = list.stream().filter(n -> Objects.equals(n.getId(), id))
                .findFirst().orElseThrow(NoSuchElementException::new);
        existing.setTitle(payload.getTitle());
        existing.setContent(payload.getContent());
        existing.setUpdatedAt(Instant.now());
        writeAll(list);
        return existing;
    }

    public synchronized void delete(long id) throws IOException {
        List<Note> list = readAll();
        list.removeIf(n -> Objects.equals(n.getId(), id));
        writeAll(list);
    }

    private List<Note> readAll() throws IOException {
        try (FileReader reader = new FileReader(file)) {
            if (file.length() == 0) return new ArrayList<>();
            return mapper.readValue(reader, new TypeReference<List<Note>>() {});
        }
    }

    private void writeAll(List<Note> notes) throws IOException {
        try (FileWriter writer = new FileWriter(file, false)) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, notes);
        }
    }
}