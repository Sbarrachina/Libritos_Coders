package org.factoriaf5.libritos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.factoriaf5.libritos.repositories.Book;
import org.factoriaf5.libritos.repositories.BookRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void loadsTheHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Autowired
    BookRepository bookRepository;

    @Test
    void returnsTheExistingBooks() throws Exception {

        Book book = bookRepository.save(new Book( "Noelia",29,"Garcia Abanto","España","Pais Vasco","Universitaria","Inspira","mujer1.jpg"));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/all"))
                .andExpect(model().attribute("books", hasItem(book)));


    }

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    void returnsAFormToAddNewBooks() throws Exception {
        mockMvc.perform(get("/books/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/edit"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attribute("title", "Create new Coder"));
    }


    @Test
    void allowsToCreateANewBook() throws Exception {
        mockMvc.perform(post("/books/new")
                        .param("nombre", "Noelia ")
                        .param("edad", "29")
                        .param("apellidos", "Garcia Abanto")
                        .param("apellidos", "Garcia Abanto")
                        .param("pais", "España")
                        .param("Localidad", "Pais Vasco")
                        .param("estudios", "universitaria")
                        .param("promo", "inspira blb")
                        .param("image", "mujer1.jpg")


                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books"))
        ;

        List<Book> existingBooks = (List<Book>) bookRepository.findAll();
        assertThat(existingBooks, contains(allOf(
                hasProperty("nombre", equalTo("Una habitación propia")),
                hasProperty("edad", equalTo("Virgia Woolf")),
                hasProperty("apellidos", equalTo("Garcia Abanto")),
                hasProperty("pais", equalTo("España")),
                hasProperty("localidad", equalTo("Pais Vasco")),
                hasProperty("estudios", equalTo("universitaria")),
                hasProperty("promo", equalTo("inspira blb")),
                hasProperty("image", equalTo("mujer1.jpg"))


        )));
    }

    @Test
    void returnsAFormToEditBooks() throws Exception {
        Book book = bookRepository.save(new Book("Noelia",29,"Garcia Abanto","España","Pais Vasco","Universitaria","Inspira BLB","mujer1.jpg"));
        mockMvc.perform(get("/books/edit/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("books/edit"))
                .andExpect(model().attribute("book", book))
                .andExpect(model().attribute("title", "Edit Coder"));
    }


    @Test
    void allowsToDeleteABook() throws Exception {
        Book book = bookRepository.save(new Book("Noelia",29,"Garcia Abanto","España","Pais Vasco","Universitaria","Inspira BLB","mujer1.jpg"));
        mockMvc.perform(get("/delete/" + book.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }


    }


