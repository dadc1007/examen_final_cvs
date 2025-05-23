package com.example.examen_cvds.service;

import com.example.examen_cvds.model.Appointment;
import com.example.examen_cvds.util.enums.Speciality;
import com.example.examen_cvds.util.enums.Status;

import java.util.List;

public interface EciSaludService {
    Appointment createAppointment(Appointment appointment);
    void cancelAppointment(String id);
    Appointment getAppointment(String cc);
    List<Appointment> getAppointments(String cc);
    List<Appointment> getAppointmentsByStatus(String cc, Status status);
    List<Speciality> getSpecialities();
}
