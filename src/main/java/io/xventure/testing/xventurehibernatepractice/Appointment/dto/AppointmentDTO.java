package io.xventure.testing.xventurehibernatepractice.Appointment.dto;

public class AppointmentDTO {
    private int id;
    private int appointmentNum;
    private String patientName;
    private int age;

    private int channelId;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int id, int appointmentNum, String patientName, int age, int channelId) {
        this.id = id;
        this.appointmentNum = appointmentNum;
        this.patientName = patientName;
        this.age = age;
        this.channelId = channelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(int appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}

