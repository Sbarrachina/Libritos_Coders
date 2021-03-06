
package org.factoriaf5.libritos.controllers;

import org.factoriaf5.libritos.repositories.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.factoriaf5.libritos.repositories.BookRepository;

import java.util.List;


@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    String listBooks(Model model) {
        List<Book> books = (List<org.factoriaf5.libritos.repositories.Book>) bookRepository.findAll();
        model.addAttribute("title", "Book list");
        model.addAttribute("books", books);
        return "books/all";
    }
    @GetMapping("/books/new")
    String newBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("title", "Create new Coder");
        return "books/edit";

    }
    @PostMapping("/books/new")
    String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }
    @GetMapping("/books/{id}/edit")
    String editBook(Model model, @PathVariable Long id){
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        model.addAttribute("title", "Edit Coder");
        return "books/edit";
    }
    @GetMapping("/books/{id}/delete")
    String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }



}






