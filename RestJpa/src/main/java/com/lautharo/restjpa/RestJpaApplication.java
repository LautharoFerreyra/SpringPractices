package com.lautharo.restjpa;

import  com.lautharo.restjpa.Controller.BookController;
import com.lautharo.restjpa.Repository.BookRepo;
import com.lautharo.restjpa.Entities.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class RestJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(RestJpaApplication.class, args);
        BookRepo repository = context.getBean(BookRepo.class);

        //CRUD
        //create book
        Book book1 = new Book(null, "El Quijote",
                "Cervantes", 1000, 20.0,
                LocalDate.of(2018, 12, 1), true);

        Book book2 = new Book(null, "Las aventuras de Tom Sawyer",
                "Mark Twain", 500, 15.0,
                LocalDate.of(2019, 1, 1), true);
        Book book3 = new Book(null, "El shbguwg",
                "CervasfAFntes", 1000, 20.0,
                LocalDate.of(2000, 11, 12), true);
        //save book
        repository.save(book1);
        repository.save(book2);
        System.out.println("All books: " + repository.findAll().size());

        //find all books
        System.out.println("All books: " + repository.findAll().size());

        //delete book
        repository.deleteById(1L);
        System.out.println("All books: " + repository.findAll().size());


    }

}
