package com.example.zmp3.Service;

public class APIService {

    private static String base_url="https://tienduc37.000webhostapp.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
