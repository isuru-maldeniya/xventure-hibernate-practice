package io.xventure.testing.xventurehibernatepractice.Appointment.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.xventure.testing.xventurehibernatepractice.Channel.Entity.Channel;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int appointmentNum;
    private String patientName;
    private int age;

    @ManyToOne
    @JoinColumn(name="channel_id",referencedColumnName = "id")
    @JsonBackReference
    private Channel channel;

    public Appointment() {
    }

    public Appointment(int appointmentNum, String patientName, int age) {
        this.appointmentNum = appointmentNum;
        this.patientName = patientName;
        this.age = age;
    }

    public Appointment(int appointmentNum, String patientName, int age, Channel channel) {
        this.appointmentNum = appointmentNum;
        this.patientName = patientName;
        this.age = age;
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
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
}
