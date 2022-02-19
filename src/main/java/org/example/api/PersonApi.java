package org.example.api;

import org.example.models.Users;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonApi
{
    @GET(".")
    Call<Users> getRandomUser();
}