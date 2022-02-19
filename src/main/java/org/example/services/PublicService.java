package org.example.services;

import org.example.api.UsersApi;
import org.example.models.Users;
import org.example.configurations.ServiceGenerator;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicService {
    private UsersApi usersApi;

    public PublicService() {
        usersApi = ServiceGenerator.createService(UsersApi.class);
    }

    public List<Users> getGithubUser() {
        try {
            Call<List<Users>> callSync = usersApi.getGithubUser();
            Response<List<Users>> response = callSync.execute();
            List<Users> usersList = new ArrayList<>();
            for (Users user : response.body()) {
                usersList.add(user);
            }
            return usersList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}