package com.example.examen_cvds.service.serviceImpl;

import com.example.examen_cvds.model.Appointment;
import com.example.examen_cvds.repository.AppointmentRepository;
import com.example.examen_cvds.service.EciSaludService;
import com.example.examen_cvds.util.enums.Speciality;
import com.example.examen_cvds.util.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EciSaludServiceImpl implements EciSaludService {
    @Autowired
    private final AppointmentRepository appointmentRepository;

    public EciSaludServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(String id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(Status.CANCELED);
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointment(String cc) {
        return appointmentRepository.findByCc(cc).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<Appointment> getAppointments(String cc) {
        List<Appointment> appointments = appointmentRepository.findAll();

        return appointments.stream().filter(appointment -> appointment.getCc().equals(cc)).toList();
    }

    @Override
    public List<Appointment> getAppointmentsByStatus(String cc, Status status) {
        List<Appointment> appointments = appointmentRepository.findAll();

        appointments = appointments.stream().filter(appointment -> appointment.getCc().equals(cc)).toList();
        appointments = appointments.stream().filter(appointment -> appointment.getStatus().equals(status)).toList();

        return appointments;
    }

    @Override
    public List<Speciality> getSpecialities() {
        return new ArrayList<>(Arrays.asList(Speciality.values()));
    }
}
