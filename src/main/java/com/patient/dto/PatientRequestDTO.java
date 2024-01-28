package com.patient.dto;

import com.patient.enums.IdentityType;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NonNull
    String patientName;

    @NonNull
    int patientAge;

    @NonNull
    String gender;

    @NonNull
    IdentityType patientIdentityType;

    @NonNull
    String patientIdentityNumber;

    @NonNull
    String patientContactNumber;

    @NonNull
    String patientEmailId;

    @NonNull
    String patientAddress;

    @NonNull
    String city;

    @NonNull
    String postalCode;

    @NonNull
    String state;

    @NonNull
    String country;

}
