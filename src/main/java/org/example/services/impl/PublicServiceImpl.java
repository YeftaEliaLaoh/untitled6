package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.jpa.entities.Users;
import org.example.jpa.repositories.UsersRepository;
import org.example.services.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService
{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ResponseEntity registerUser(Users users)
    {
        usersRepository.save(users);
        return new ResponseEntity(HttpStatus.OK);
    }
}