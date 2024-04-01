package dev.mritunjay.springcacheredis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Car implements Serializable {      // redis donot implement by default the Serializable class (which converts objects into JSON and vice-versa)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand;
    private String model;
}
