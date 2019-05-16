package com.halimah.temaminimarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.halimah.temaminimarket.MainActivity;
import com.halimah.temaminimarket.model.DataModel;

import java.util.List;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    List<DataModel> mList ;
    Context ctx;

    public RecyclerAdapter(Context ctx, List<DataModel>mList){
        this.mList = mList;
        this.ctx = ctx;
    }

    @Override
    public RecyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyHolder holder, final int position){
        holder.kode.setText(mList.get(position).getmKode());
        holder.nama.setText(mList.get(position).getmNama());
        holder.alamat.setText(mList.get(position).getmAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view){
            Intent goInput = new Intent(ctx, MainActivity.class);
            try {
                goInput.putExtra("kode", mList.get(position).getmKode());
                goInput.putExtra("nama", mList.get(position).getmNama());
                goInput.putExtra("alamat", mList.get(position).getmAlamat());

                ctx.startActivity(goInput);

            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(ctx, "Eror data" + e, Toast.LENGTH_SHORT).show();
            }
        }
    });

    }

    @Override
    public int getItemCount(){
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView kode, nama, alamat;
        DataModel dataModel;
        public MyHolder(View view){
            super(view);

            nama = (TextView) view.findViewById(R.id.tvNama);
            alamat = (TextView) view.findViewById(R.id.tvAlamat);
        }
    }
}
