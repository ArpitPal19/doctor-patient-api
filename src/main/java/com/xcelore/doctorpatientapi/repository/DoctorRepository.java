
package com.xcelore.doctorpatientapi.repository;

import com.xcelore.doctorpatientapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
