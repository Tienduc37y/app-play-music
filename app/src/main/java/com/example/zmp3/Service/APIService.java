package com.example.zmp3.Service;
//lớp trung gian để lấy đối tượng dịch vụ
public class APIService {

    private static String base_url="https://tienduc37.000webhostapp.com/Server/";
    // tương tác dữ liệu trả về dataservice
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
