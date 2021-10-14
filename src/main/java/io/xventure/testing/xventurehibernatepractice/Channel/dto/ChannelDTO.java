package io.xventure.testing.xventurehibernatepractice.Channel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;

public class ChannelDTO {
    private int id;
    private String startTime;
    private String endTime;
    private LocalDate date;
    private int numOfPatients;
    private int filledPatientsAmount;

    private int doctorId;

    public ChannelDTO() {
    }

    public ChannelDTO(int id, String startTime, String endTime, LocalDate date, int numOfPatients, int filledPatientsAmount, int doctorId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.numOfPatients = numOfPatients;
        this.filledPatientsAmount = filledPatientsAmount;
        this.doctorId = doctorId;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
