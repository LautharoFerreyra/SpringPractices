package com.lautharo.autosjpa.Repositoty;


import com.lautharo.autosjpa.Entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends JpaRepository<Cars, Long> {
}
