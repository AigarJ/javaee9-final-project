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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Clock;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String header;
    @NotEmpty
    @Size(min = 3, message = "You're post is too short:)")
    String content;
    // TODO: move exact values to one common place
    @NotEmpty
    @Size(min = 3, message = "Author name is too short:)")
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