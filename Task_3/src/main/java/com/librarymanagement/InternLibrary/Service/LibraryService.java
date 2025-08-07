package com.librarymanagement.InternLibrary.Service;

import com.librarymanagement.InternLibrary.Entity.Book;
import com.librarymanagement.InternLibrary.Entity.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public LibraryService() {
        books.add(new Book(1, "book 1", "author 1"));
        books.add(new Book(2, "book 2", "author 2"));
        users.add(new User(101, "harsh"));
        users.add(new User(102, "amit"));
    }

    public List<Book> getAllBooks() { return books; }
    public void addBook(Book book) { books.add(book); }

    public List<User> getAllUsers() { return users; }
    public void addUser(User user) { users.add(user); }

    public String issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book != null && user != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                user.borrowBook(book);
                return "Book '" + book.getTitle() + "' issued to " + user.getName();
            } else {
                return "Book '" + book.getTitle() + "' is not available.";
            }
        }
        return "Invalid book ID or user ID.";
    }

    public String returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book != null && user != null) {
            if (user.getBorrowedBooks().contains(book)) {
                book.setAvailable(true);
                user.returnBook(book);
                return "Book '" + book.getTitle() + "' returned by " + user.getName();
            } else {
                return "This book was not borrowed by " + user.getName();
            }
        }
        return "Invalid book ID or user ID.";
    }

    private Book findBookById(int bookId) {
        return books.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
    }

    private User findUserById(int userId) {
        return users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
    }
}
