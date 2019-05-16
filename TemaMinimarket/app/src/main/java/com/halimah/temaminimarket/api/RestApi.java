package com.halimah.temaminimarket.api;

import com.halimah.temaminimarket.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    //insert
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModel> sendMinimarket(@Field("kode") String kode,
                                       @Field("nama") String nama,
                                       @Field("alamat") String alamat);

    //read
    @GET("read.php")
    Call<ResponseModel>getMinimarket();
}
