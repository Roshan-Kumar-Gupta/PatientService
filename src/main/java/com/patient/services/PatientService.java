package com.patient.services;

import com.patient.dto.PatientRequestDTO;
import org.springframework.http.ResponseEntity;

public interface PatientService {
    ResponseEntity<Object> onboardPatient(PatientRequestDTO patientRequestDTO);

    ResponseEntity<Object> updatePatient(String patientContactNumber, PatientRequestDTO patientRequestDTO);

    ResponseEntity<Object> getAllPatientDetails();
    ResponseEntity<Object> getPatientDetails(String patientContactNumber);
}
