package dev.mritunjay.springcacheredis.repository;

import dev.mritunjay.springcacheredis.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
