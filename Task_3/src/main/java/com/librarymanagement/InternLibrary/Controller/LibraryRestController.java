package com.librarymanagement.InternLibrary.Controller;


import com.librarymanagement.InternLibrary.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryRestController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/api/issue")
    public ResponseEntity<String> issueBook(@RequestParam int bookId, @RequestParam int userId) {
        String message = libraryService.issueBook(bookId, userId);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/api/return")
    public ResponseEntity<String> returnBook(@RequestParam int bookId, @RequestParam int userId) {
        String message = libraryService.returnBook(bookId, userId);
        return ResponseEntity.ok(message);
    }
}