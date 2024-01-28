package com.patient.services;

import com.patient.dto.PatientRequestDTO;
import com.patient.exception.ValidationException;
import com.patient.entities.PatientDetails;
import com.patient.repository.PatientDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
@Slf4j
@Service
public class PatientServiceImplementation implements PatientService{

    private final PatientDetailsRepository patientDetailsRepository;

    public PatientServiceImplementation(PatientDetailsRepository patientDetailsRepository) {
        this.patientDetailsRepository = patientDetailsRepository;
    }

    @Override
    public ResponseEntity<Object> onboardPatient(PatientRequestDTO patientRequestDTO) {
      if(Objects.nonNull(patientDetailsRepository.findByPatientContactNumber(patientRequestDTO.getPatientContactNumber()))){
          throw new ValidationException("Patient is already exists for the given mobile number");
      }
        if(Objects.nonNull(patientDetailsRepository.findByPatientEmailId(patientRequestDTO.getPatientEmailId()))){
            throw new ValidationException("Patient is already exists for the given mobile number");
        }
        PatientDetails patientDetails = PatientDetails.builder()
                .patientName(patientRequestDTO.getPatientName())
                .patientAge(patientRequestDTO.getPatientAge())
                .gender(patientRequestDTO.getGender())
                .patientIdentityType(patientRequestDTO.getPatientIdentityType())
                .patientIdentityNumber(patientRequestDTO.getPatientIdentityNumber())
                .patientContactNumber(patientRequestDTO.getPatientContactNumber())
                .patientEmailId(patientRequestDTO.getPatientEmailId())
                .patientAddress(patientRequestDTO.getPatientAddress())
                .city(patientRequestDTO.getCity())
                .postalCode(patientRequestDTO.getPostalCode())
                .state(patientRequestDTO.getState())
                .country(patientRequestDTO.getCountry())
                .build();
        patientDetailsRepository.save(patientDetails);

        return new ResponseEntity<>("Patient Onboarded succesfully", HttpStatus.OK);
    }

    public ResponseEntity<Object> updatePatient(String patientContactNumber, PatientRequestDTO patientRequestDTO){
        PatientDetails patientDetails = patientDetailsRepository.findByPatientContactNumber(patientContactNumber);
        if(Objects.isNull(patientDetails)){
            throw new ValidationException("Patient is not present for the given mobile number");
        }
        patientDetails.setPatientName(patientRequestDTO.getPatientName());
        patientDetails.setPatientAge(patientRequestDTO.getPatientAge());
        patientDetails.setPatientAddress(patientRequestDTO.getPatientAddress());
        patientDetails.setPatientEmailId(patientRequestDTO.getPatientEmailId());
        patientDetails.setCity(patientRequestDTO.getCity());
        return new ResponseEntity<>("Patient details updated succesfully", HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllPatientDetails(){
        List<PatientDetails> list = patientDetailsRepository.findAll();
        return new ResponseEntity<>("Get all the patient details \n"+ list, HttpStatus.OK);
    }

    public ResponseEntity<Object> getPatientDetails(String patientContactNumber){
        PatientDetails patientDetails = patientDetailsRepository.findByPatientContactNumber(patientContactNumber);
        if(Objects.isNull(patientDetails)){
            throw new ValidationException("Patient is not present for the given mobile number");
        }
        return new ResponseEntity<>("Get the patient details \n"+ patientDetails, HttpStatus.OK);
    }
}
