package org.example.services;

import org.example.api.PersonApi;
import org.example.models.Users;
import org.example.configurations.ServiceGenerator;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

import java.util.HashMap;

@Service
public class PublicService
{
    private PersonApi personApi;

    public PublicService()
    {
        personApi = ServiceGenerator.createService(PersonApi.class);
    }

    public HashMap<String, String> getRandomUser()
    {
        Call<Users> callSync = personApi.getRandomUser();
        HashMap<String, String> hashMap = new HashMap<>();

        try
        {
            Response<User> response = callSync.execute();
            String gender = response.body().getResults().get(0).getGender();
            String title = response.body().getResults().get(0).getName().getTitle();
            String first = response.body().getResults().get(0).getName().getFirst();
            String last = response.body().getResults().get(0).getName().getLast();
            int numberStreet = response.body().getResults().get(0).getLocation().getStreet().getNumber();
            String nameStreet = response.body().getResults().get(0).getLocation().getStreet().getName();
            String city = response.body().getResults().get(0).getLocation().getCity();
            String picture = response.body().getResults().get(0).getPicture().getLarge();

            hashMap.put("gender", gender);
            hashMap.put("fullname", title + " " + first + " " + last);
            hashMap.put("address", numberStreet + " " + nameStreet + " " + city);
            hashMap.put("picture", picture);
            return hashMap;

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return hashMap;
    }
}