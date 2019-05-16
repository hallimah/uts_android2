package com.halimah.temaminimarket.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataModel {

        @SerializedName("kode")
        private String mKode;

        @SerializedName("nama")
        private String mNama;

        @SerializedName("alamat")
        private String mAlamat;

        public String getmKode(){
            return mKode;
        }

        public void setmKode(String mKode) {
            mKode = mKode;
        }

        public String getmNama(){
            return mNama;
        }

        public void setmNama(String mNama){
            mNama = mNama;
        }

        public String getmAlamat(){
            return mAlamat;
        }

        public void setmAlamat(String mAlamat){
            mAlamat = mAlamat;
        }

    }
