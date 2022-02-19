package org.example.api;

import org.example.models.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface UsersApi
{
    @GET("/users?per_page=50")
    Call<List<Users>> getGithubUser();
}