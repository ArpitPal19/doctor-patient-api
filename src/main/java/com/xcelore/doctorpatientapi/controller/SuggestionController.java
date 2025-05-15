
package com.xcelore.doctorpatientapi.controller;

import com.xcelore.doctorpatientapi.entity.Doctor;
import com.xcelore.doctorpatientapi.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggest")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/{patientId}")
    public List<Doctor> suggestDoctors(@PathVariable Long patientId) {
        return suggestionService.suggestDoctors(patientId);
    }
}
