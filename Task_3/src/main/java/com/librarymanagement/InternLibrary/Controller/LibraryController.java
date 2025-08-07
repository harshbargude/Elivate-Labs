package com.librarymanagement.InternLibrary.Controller;


import com.librarymanagement.InternLibrary.Entity.Book;
import com.librarymanagement.InternLibrary.Entity.User;
import com.librarymanagement.InternLibrary.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String index() {

        return "index";

    }

    @GetMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", libraryService.getAllBooks());
        return "books";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", libraryService.getAllUsers());
        return "users";
    }

    @GetMapping("/issue")
    public String issueBookForm() {
        return "issue";

    }

    @PostMapping("/issue")
    public String issueBook(@RequestParam int  bookId, @RequestParam  int userId, Model model) {
        String message = libraryService.issueBook(bookId,userId);
        model.addAttribute("message",message);

        return "issue";
    }

    @GetMapping("/return" )
    public String returnBookForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook( @RequestParam int bookId,  @RequestParam int  userId, Model model) {
        String message = libraryService.returnBook(bookId, userId);
        model.addAttribute("message", message);
        return "return";
    }

    @PostMapping("/addBook")
    public String addBook (@RequestParam int bookId, @RequestParam String title, @RequestParam String author) {
        libraryService.addBook(new Book(bookId, title, author));
        return "redirect:/books";
    }

    @PostMapping("/addUser" )
    public String addUser(@RequestParam int userId, @RequestParam String name) {
        libraryService.addUser(new User(userId, name));
        return "redirect:/users";
    }
}
