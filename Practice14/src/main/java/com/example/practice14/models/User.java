package com.example.practice14.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
}
