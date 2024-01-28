package com.patient.repository;

import com.patient.entities.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
    PatientDetails findByPatientContactNumber(String patientContactNumber);

    PatientDetails findByPatientEmailId(String patientEmailId);
}
