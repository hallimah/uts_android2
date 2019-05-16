package com.halimah.temaminimarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.halimah.temaminimarket.adapter.RecyclerAdapter;
import com.halimah.temaminimarket.api.RestApi;
import com.halimah.temaminimarket.api.RetroServer;
import com.halimah.temaminimarket.model.DataModel;
import com.halimah.temaminimarket.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilData extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItems = new ArrayList<>();
    ProgressBar pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        pd = (ProgressBar) findViewById(R.id.pd);
        pd.setIndeterminate(true);
        pd.setVisibility(View.VISIBLE);


        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mManager);

        RestApi api = RetroServer.getClient().create(RestApi.class);
        Call<ResponseModel> getdata = api.getMinimarket();
        getdata.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pd.setVisibility(View.GONE);
                Log.d("RETRO", "RESPONSE : " +
                        response.body().getmKodemini());

                mItems = response.body().getResult();

                mAdapter = new RecyclerAdapter(TampilData.this,mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                pd.setVisibility(View.GONE);
//pd.setVisibility(View.GONE);

                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }
}
