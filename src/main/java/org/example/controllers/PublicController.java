package org.example.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.example.services.PublicService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController
{
    @PostMapping("/check")
    public String name() {
        return "OK";
    }

    PublicService publicService;

    @GetMapping("/person")
    public HashMap<String, String> GetPerson(HttpServletRequest request)
    {
        publicService = new PublicService();
        return  publicService.getRandomUser();
    }
}
