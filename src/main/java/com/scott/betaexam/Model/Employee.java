package com.scott.betaexam.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String addressLine1;
    private String city;
    private String state;
    private String createDate;

}
