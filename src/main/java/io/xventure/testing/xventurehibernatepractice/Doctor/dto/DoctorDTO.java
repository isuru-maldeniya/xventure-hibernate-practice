package io.xventure.testing.xventurehibernatepractice.Doctor.dto;

public class DoctorDTO {
    private int id;
    private String name;
    private String specialization;
    private String hospital;

    public DoctorDTO() {
    }

    public DoctorDTO(int id, String name, String specialization, String hospital) {
        this.id = id;
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
