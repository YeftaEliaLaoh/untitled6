package org.example.services;

import org.example.jpa.entities.Users;
import org.springframework.http.ResponseEntity;

public interface PublicService {
    ResponseEntity registerUser(Users users);
}
