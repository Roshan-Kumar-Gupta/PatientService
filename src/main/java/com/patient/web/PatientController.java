package com.patient.web;

import com.patient.dto.PatientRequestDTO;
import com.patient.services.PatientService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping(value = "/onboard/patientDetails")
    public ResponseEntity<Object> onboardPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.onboardPatient(patientRequestDTO);
    }

    @PutMapping(value = "/update/patientDetails/{patientContactNumber}")
    public ResponseEntity<Object> updatePatient(@PathVariable(value = "patientContactNumber") final String patientContactNumber,
                                                @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.updatePatient(patientContactNumber,patientRequestDTO);
    }

    @Cacheable("patients")
    @GetMapping(value = "/getAll/patientDetails")
    public ResponseEntity<Object> getAllPatientDetails() {
        return patientService.getAllPatientDetails();
    }

    @Cacheable("patients")
    @GetMapping(value = "/get/patientDetails/{patientContactNumber}")
    public ResponseEntity<Object> getPatientDetails(@PathVariable(value = "patientContactNumber") final String patientContactNumber) {
        return patientService.getPatientDetails(patientContactNumber);
    }
}
