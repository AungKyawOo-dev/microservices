package com.aungkyawoo.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@ToString
public class BaseEntity {

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(updatable = false)
    @CreatedBy
    private String createdBy;
    @Column(updatable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    @LastModifiedBy
    private String updatedBy;
}
