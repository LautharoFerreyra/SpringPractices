package com.lautharo.restjpa.Controller;

import com.lautharo.restjpa.Entities.Book;
import com.lautharo.restjpa.Repository.BookRepo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Buscar todos los libros que estan en la db

    @GetMapping("/api/books")
    public List<Book> findAll() {
        //recupeara y devolver los libros de la db
        return repository.findAll();

    }


    //Buscar un libro por id
    @GetMapping("/api/books/{id}")
    public ResponseEntity <Book> findById(@PathVariable Long id) {
        //con el pathvariable encuentra el libro por su Id  con el {id}
        //Recuperar y devolver un libro por id
        //op 1
        Optional<Book> bookOpt= repository.findById(id);
        if (bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        //op 2
        //return repository.findById(id).orElse(null);
    }


    //Crear un libro en la base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Object> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //guardar libro
        if(book.getId() != null ) {// quiere decir que existe el id y por lo tanto no es una creacio
            log.warn("");


            return ResponseEntity.badRequest().build();
        }
        return repository.save(book);


    }

    //Actualizar un libro existente en la db

    @PutMapping("/api/books")
    public Book update(@RequestBody Book book){
        return repository.save(book);
    }

    // Borrar un libro de la base de datos

}
