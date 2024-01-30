package com.example.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // It will generate Id automatically means no need to it manually..
    private Integer id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String street;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    private String state;

    @Enumerated(EnumType.STRING) //  it will save enum in db as string not ordinal(integer) as by default it saves as ordinal..
    private Gender gender;
    @Pattern(regexp = "^\\w+@gmail\\.com$") // validation on email that it should end wit @gmail.com..
    private String email;
    private String username;

    private String contactNo;
    @NotBlank
    private String password;

}
