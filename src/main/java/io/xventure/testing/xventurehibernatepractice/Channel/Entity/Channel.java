package io.xventure.testing.xventurehibernatepractice.Channel.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.xventure.testing.xventurehibernatepractice.Appointment.Entity.Appointment;
import io.xventure.testing.xventurehibernatepractice.Doctor.Entity.Doctor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String startTime;
    private String endTime;
    private LocalDate date;
    private int numOfPatients;
    private int filledPatientsAmount;

    @OneToMany(mappedBy = "channel")
    @JsonManagedReference
    private List<Appointment> appointments=new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    @JsonBackReference
    private Doctor doctor;

    public Channel() {
    }

    public Channel(int id, String startTime, String endTime, LocalDate date, int numOfPatients, int filledPatientsAmount, Doctor doctor) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.numOfPatients = numOfPatients;
        this.filledPatientsAmount = filledPatientsAmount;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumOfPatients() {
        return numOfPatients;
    }

    public void setNumOfPatients(int numOfPatients) {
        this.numOfPatients = numOfPatients;
    }

    public int getFilledPatientsAmount() {
        return filledPatientsAmount;
    }

    public void setFilledPatientsAmount(int filledPatientsAmount) {
        this.filledPatientsAmount = filledPatientsAmount;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
