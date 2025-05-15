
package com.xcelore.doctorpatientapi.controller;

import com.xcelore.doctorpatientapi.entity.Patient;
import com.xcelore.doctorpatientapi.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repo;

    @PostMapping
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        return repo.save(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
