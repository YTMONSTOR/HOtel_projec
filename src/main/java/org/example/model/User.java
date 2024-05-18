package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String fullName;
    private double balance;
    private String phoneNumber;
    private String email;
    private boolean bant;
}
