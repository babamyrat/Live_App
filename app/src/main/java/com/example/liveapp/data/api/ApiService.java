package com.example.liveapp.data.api;




import com.example.liveapp.domain.response.UserResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/29f71801ced1d41961c2")
    Observable<UserResponse> getUserResponses();
}
