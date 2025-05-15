
package com.xcelore.doctorpatientapi.service;

import com.xcelore.doctorpatientapi.entity.*;
import com.xcelore.doctorpatientapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class SuggestionService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    private static final Map<Symptom, Speciality> symptomSpecialityMap = Map.ofEntries(
        Map.entry(Symptom.ARTHRITIS, Speciality.ORTHOPAEDIC),
        Map.entry(Symptom.BACK_PAIN, Speciality.ORTHOPAEDIC),
        Map.entry(Symptom.TISSUE_INJURIES, Speciality.ORTHOPAEDIC),
        Map.entry(Symptom.DYSMENORRHEA, Speciality.GYNECOLOGY),
        Map.entry(Symptom.SKIN_INFECTION, Speciality.DERMATOLOGY),
        Map.entry(Symptom.SKIN_BURN, Speciality.DERMATOLOGY),
        Map.entry(Symptom.EAR_PAIN, Speciality.ENT)
    );

    public List<Doctor> suggestDoctors(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));

        String city = patient.getCity();
        if (!List.of("Delhi", "Noida", "Faridabad").contains(city)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We are still waiting to expand to your location");
        }

        Speciality speciality = symptomSpecialityMap.get(patient.getSymptom());
        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);

        if (doctors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn’t any doctor present at your location for your symptom");
        }

        return doctors;
    }
}
