package com.patient.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Version
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @Column(name = "version")
    private int version;

    @CreatedBy
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @JsonIgnore
    @LastModifiedBy
    @Setter(AccessLevel.NONE)
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}