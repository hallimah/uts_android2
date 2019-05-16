package com.halimah.temaminimarket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ResponseModel {
    List<DataModel> result;
    @SerializedName("kodemini")
    private String mKodemini;
    @SerializedName("psean")
    private String pesan;

    public List<DataModel>getResult(){
        return result;
    }

    public void setResult(List<DataModel> result) {
        this.result = result;
    }

    public String getmKodemini() {
        return mKodemini;
    }

    public void setmKodemini(String mKodemini) {
        mKodemini = mKodemini;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        pesan = pesan;
    }
}
