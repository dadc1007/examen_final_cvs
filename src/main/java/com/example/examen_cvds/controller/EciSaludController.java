package com.example.examen_cvds.controller;

import com.example.examen_cvds.model.Appointment;
import com.example.examen_cvds.service.EciSaludService;
import com.example.examen_cvds.util.enums.Speciality;
import com.example.examen_cvds.util.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class EciSaludController {
    @Autowired
    private final EciSaludService eciSaludService;

    public EciSaludController(EciSaludService eciSaludService) {
        this.eciSaludService = eciSaludService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok().body(eciSaludService.createAppointment(appointment));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> cancelAppointment(@PathVariable String id) {
        eciSaludService.cancelAppointment(id);
        return ResponseEntity.ok().body("Appointment cancelled");
    }

    @GetMapping("/{cc}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable String cc) {
        return ResponseEntity.ok().body(eciSaludService.getAppointment(cc));
    }

    @GetMapping("/appointment/{cc}")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable String cc) {
        return ResponseEntity.ok().body(eciSaludService.getAppointments(cc));
    }

    @GetMapping("/appointment")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable String cc, @PathVariable Status status) {
        return ResponseEntity.ok().body(eciSaludService.getAppointmentsByStatus(cc, status));
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<Speciality>> getSpecialities() {
        return ResponseEntity.ok().body(eciSaludService.getSpecialities());
    }
}
