package com.example.vmac.WatBot.Service;

import com.example.vmac.WatBot.Model.Pfr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LISET on 22/05/2018.
 */

public interface ApiService {
    String API_BASE_URL = "https://productosapi-liset08.c9users.io";

    @GET("api/v1/pfr")
    Call<List<Pfr>> getPfr();

}
