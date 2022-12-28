package com.sparta.springeducation.application.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Timestamp {

    @CreatedDate // insert 나를 찾아서 넣어라
    @Column(updatable = false, name = "created_at")
    private LocalDateTime dateCreated;
    @LastModifiedDate // updae 나를 찾아서 넣고
    @Column(name = "updated_at")
    private LocalDateTime dateUpdated;


}
