package com.example.examen_cvds.model;

import com.example.examen_cvds.util.enums.Speciality;
import com.example.examen_cvds.util.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointments")
public class Appointment {
    @Id private String id;
    private String patient;
    private String cc;
    private String email;
    private String date;
    private Speciality speciality;
    private String doctor;
    private String ubication;
    private Status status = Status.CONFIRMED;

    public Appointment() {
    }

    public Appointment(String patient, String cc, String email, String date, Speciality speciality, String doctor, String ubication) {
        this.patient = patient;
        this.cc = cc;
        this.email = email;
        this.date = date;
        this.speciality = speciality;
        this.doctor = doctor;
        this.ubication = ubication;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
