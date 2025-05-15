
package com.xcelore.doctorpatientapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Doctor {
    @Id @GeneratedValue
    private Long id;

    @Size(min = 3)
    private String name;

    @Size(max = 20)
    private String city;

    @Email
    private String email;

    @Size(min = 10)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // Getters and Setters
}
