package com.example.zmp3.Service;

import com.example.zmp3.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {


    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

}
