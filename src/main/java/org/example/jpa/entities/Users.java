package org.example.jpa.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {

    @Id
    private String userName;
    private String password;
    private String name;
    private String dateBirth;
    private String phoneNumber;
}