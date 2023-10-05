package com.lautharo.SpringDataJpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
//        run(SpringDataJpaApplication.class, args);
        ApplicationContext context = (ApplicationContext) SpringApplication.run(SpringDataJpaApplication.class, args);
        CocheRepository repository = context.getBean(CocheRepository.class);

        System.out.println("Find");
        System.out.println( "El numero de coche en la DB es: " + repository.count());

        //crear y almacenar coche en bd
        Coche toyota = new Coche(null,"Toyota","Prius",2010);
        repository.save(toyota);

        System.out.println( "El numero de coche en la DB es: " + repository.count());
        //recuperar todos los coches

        System.out.println(repository.findAll());
    }

}
