package org.example.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lowagie.text.DocumentException;
import org.example.models.Users;
import org.example.pdf.UserPDFExporter;
import org.example.services.PublicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    PublicService publicService;

    @PostMapping("/check")
    public String name() {
        return "OK";
    }

    @GetMapping("/person")
    public void GetPerson(HttpServletResponse httpServletResponse) throws DocumentException,IOException {

        httpServletResponse.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        httpServletResponse.setHeader(headerKey, headerValue);

        List<Users> listUsers = publicService.getGithubUser();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(httpServletResponse);
    }
}
