package com.example.vmac.WatBot.Service;

import com.example.vmac.WatBot.Model.Cpe;
import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.Model.tipocurso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LISET on 22/05/2018.
 */

public interface ApiService {
    String API_BASE_URL = "https://productosapi-liset08.c9users.io";

    @GET("api/v1/pfr")
    Call<List<Pfr>> getPfr();

    @GET("api/v1/cursos")
    Call<List<tipocurso>> gettcurso();
    @GET("api/v1/pfr/{id}")
    Call<Pfr> showPfr(@Path("id") Integer id);
    @GET("api/v1/cpe/{tipo}")
    Call<List<Cpe>> showCpe(@Path("tipo") String tipo);

}
