package com.lautharo.restjpa.Controller;

import com.lautharo.restjpa.Entities.Book;
import com.lautharo.restjpa.Repository.BookRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    //atributos
    private BookRepo repository;

    //constructores

    public BookController(BookRepo repository) {
        this.repository = repository;
    }


    //Crud sobre la entidad Book

    //Buscar todos los libros

    @GetMapping("/api/books")
    public List<Book> findAll() {
        //recupeara y devolver los libros de la db

        return repository.findAll();

    }


    //Buscar un libro por id
    @GetMapping("/api/books/{id}")
    public ResponseEntity <Book> findById(@PathVariable Long id) {
        //Recuperar y devolver un libro por id
        //op 1
        Optional<Book> bookOpt= repository.findById(id);
        if (bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        //op 2
//        return repository.findById(id).orElse(null);
    }

    //Crear un libro en la base de datos
    @PostMapping("/api/books")
    public Book create(Book book){
    //guardar libro
        repository.save(book);
        return book;

    }

    // Borrar un libro de la base de datos

}
