package com.halimah.temaminimarket;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.halimah.temaminimarket.api.RestApi;
import com.halimah.temaminimarket.api.RetroServer;
import com.halimah.temaminimarket.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText kode, nama, alamat;
    Button btnsave, btnTampildata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kode = (EditText)findViewById(R.id.tx_kode);
        nama = (EditText) findViewById(R.id.tx_nama);
        alamat = (EditText) findViewById(R.id.tx_alamat);
        btnsave = (Button)findViewById(R.id.btn_save);
        btnTampildata = (Button) findViewById(R.id.btn_tampil);

        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null){
            btnsave.setVisibility(View.GONE);
            btnTampildata.setVisibility(View.GONE);
            kode.setText(data.getStringExtra("kode"));
            nama.setText(data.getStringExtra("nama"));
            alamat.setText(data.getStringExtra("alamat"));
        }

        //tampil
        btnTampildata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TampilData.class));
            }
        });

        //insert
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skode = kode.getText().toString();
                String snama = nama.getText().toString();
                String salamat = alamat.getText().toString();

                if (skode.isEmpty()){
                    kode.setError("isi kode");

                }else if(snama.isEmpty()) {
                    nama.setError("isi nama");
                } else if (salamat.isEmpty()){
                    alamat.setError("isi alamat");
                }else {
                    RestApi api = RetroServer.getClient().create(RestApi.class);
                    Call<ResponseModel> sendmini = api.sendMinimarket(skode, snama,salamat);

                    sendmini.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                            Log.d("RETRO", "response : " + response.body().toString());
                            String kodemini = response.body().getmKodemini();

                            if (kodemini.equals("1")){
                                Toast.makeText(MainActivity.this, "data berhasil disimpan",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, TampilData.class));
                                kode.getText().clear();
                                nama.getText().clear();
                                alamat.getText().clear();
                            }else {
                                Toast.makeText(MainActivity.this, "data eror",Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                            Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");

                        }
                    });
                }
            }
        });
    }
@Override
    public void onBackPressed(){
    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("warnig");
    alert.setMessage("do you wan to exit");

    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.finish();
        }
    });
    alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });

    AlertDialog alertDialog = alert.create(); alertDialog.show();
}

}
