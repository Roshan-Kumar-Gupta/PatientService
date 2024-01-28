package com.patient.entities;

import com.patient.enums.IdentityType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "client_request_detail")
public class PatientDetails extends AuditModel{

    @Setter
    @Getter
    private String patientName;

    @Setter
    @Getter
    private int patientAge;

    @Setter
    @Getter
    private String gender;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private IdentityType patientIdentityType;

    @Setter
    @Getter
    private String patientIdentityNumber;

    @Setter
    @Getter
    private String patientContactNumber;

    @Setter
    @Getter
    private String patientEmailId;


    @Setter
    @Getter
    private String patientAddress;

    @Setter
    @Getter
    private String city;

    @Setter
    @Getter
    private String postalCode;

    @Setter
    @Getter
    private String state;

    @Setter
    @Getter
    private String country;

}