package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Clock;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

// TODO: add the same validation as in dto
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String header;
    String content;
    String author;
    ZonedDateTime creationTimestamp;
    ZonedDateTime updateTimestamp;

    @PrePersist
    private void setInitialTimestamp() {
        ZonedDateTime timestamp = ZonedDateTime.now(Clock.systemUTC());
        creationTimestamp = timestamp;
        updateTimestamp = timestamp;
    }

    @PreUpdate
    private void setUpdateTimestamp() {
        updateTimestamp = ZonedDateTime.now(Clock.systemUTC());
    }
}