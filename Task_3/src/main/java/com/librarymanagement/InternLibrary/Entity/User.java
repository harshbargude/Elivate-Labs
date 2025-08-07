package com.librarymanagement.InternLibrary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private int userId;
    private String name;
    @ManyToMany
    private List<Book> borrowedBooks = new ArrayList<>();

    public User() {}
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(List<Book> borrowedBooks) { this.borrowedBooks = borrowedBooks; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }

    @Override
    public String toString() {
        return "User [ID=" + userId + ", Name=" + name + ", Borrowed Books=" + borrowedBooks + "]";
    }
}