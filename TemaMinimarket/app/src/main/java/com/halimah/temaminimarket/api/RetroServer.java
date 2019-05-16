package com.halimah.temaminimarket.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String base_url = "http://10.148.254.82/minimarket/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
