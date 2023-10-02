package com.lautharo.autosjpa.Controllers;


import com.lautharo.autosjpa.Entities.Cars;
import com.lautharo.autosjpa.Repositoty.CarsRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Carscontrollers {


    //atributo: un atributo se refiere a una variable que está asociada a una clase
    private CarsRepo repository;

    //constructores: un constructor es un método especial que se utiliza para inicializar objetos de una clase.

    public Carscontrollers(CarsRepo repository){
        this.repository = repository;
    }

    //Crud

    //Busca los Autos

    @GetMapping("/autos")
    public List<Cars> findAll(){
        //recupea y devuelve los autos de la db
        return repository.findAll();
    }

    @GetMapping("/autos/{id}")
    public ResponseEntity<Cars>findById(@PathVariable Long id){
        //recuperar y devolver un libro por id
        Optional<Cars> carsOpt = repository.findById(id);
        if(carsOpt.isPresent()) {
            return ResponseEntity.ok(carsOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Crear un Auto
    @PostMapping("/autos")
    public Cars crearte(Cars cars){
        repository.save(cars);
        return cars;
    }
























}
