package com.lautharo.autosjpa;


import com.lautharo.autosjpa.Entities.Cars;
import com.lautharo.autosjpa.Repositoty.CarsRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class AutosJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AutosJpaApplication.class, args);
		CarsRepo repository = context.getBean(CarsRepo.class);

		//Crud
		//create Car
		Cars car1 = new Cars(null, "Model Y", "Tesla", "Y",
				"White", 64000);
		Cars car2 = new Cars(null, "Model X", "Tesla", "X",
				"White", 70000);
		Cars car3 = new Cars(null, "Model z", "Tesla", "z",
				"White", 80000);

		//save cars
		repository.save(car1);
		repository.save(car2);
		repository.save(car3);
		System.out.println("All Cars: " +  repository.findAll().size());

		//find all books
		System.out.println("All books: " + repository.findAll().size());



	}

}
