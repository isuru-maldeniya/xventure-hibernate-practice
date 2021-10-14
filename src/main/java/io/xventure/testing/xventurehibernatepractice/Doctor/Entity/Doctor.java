package io.xventure.testing.xventurehibernatepractice.Doctor.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.xventure.testing.xventurehibernatepractice.Channel.Entity.Channel;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private String hospital;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Channel> channels=new LinkedList<>();

    public Doctor() {
    }

    public Doctor(String name, String specialization, String hospital) {
        this.name = name;
        this.specialization = specialization;
        this.hospital = hospital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
