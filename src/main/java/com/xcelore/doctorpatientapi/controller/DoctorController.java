
package com.xcelore.doctorpatientapi.controller;

import com.xcelore.doctorpatientapi.entity.Doctor;
import com.xcelore.doctorpatientapi.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repo;

    @PostMapping
    public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
