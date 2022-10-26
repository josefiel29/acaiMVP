package com.example.acaimvp;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("v1/users/signin")
    Call <LoginResponse> userLogin(@Body LoginRequest loginRequest);

}
