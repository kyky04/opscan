package com.skripsi.innasya.optscan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skripsi.innasya.optscan.Model.Pestisida;
import com.skripsi.innasya.optscan.R;

import java.util.List;

/**
 * Created by Comp on 1/24/2018.
 */

public class AdapterPestisida extends RecyclerView.Adapter<AdapterPestisida.MyHolder> {
    Context  context;
    List<Pestisida> pestisidaList;

    public AdapterPestisida(Context context, List<Pestisida> pestisidaList) {
        this.context = context;
        this.pestisidaList = pestisidaList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_pestisida,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvMerek.setText(pestisidaList.get(position).getMerekDagang());
        holder.tvBahanAktif.setText(pestisidaList.get(position).getBahanAktif());
        holder.tvKode.setText(pestisidaList.get(position).getCaraKerja());
        holder.tvBahaya.setText(pestisidaList.get(position).getBahayaPestisida());
    }

    @Override
    public int getItemCount() {
        return pestisidaList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvMerek;
        TextView tvBahanAktif;
        TextView tvKode;
        TextView tvBahaya;
        public MyHolder(View itemView) {
            super(itemView);
            tvMerek = (TextView)itemView.findViewById(R.id.tv_merek_dagang);
            tvBahanAktif = (TextView)itemView.findViewById(R.id.tv_bahan_aktif);
            tvKode = (TextView)itemView.findViewById(R.id.tv_kode_kerja);
            tvBahaya = (TextView)itemView.findViewById(R.id.tv_tingkat_bahaya);

        }
    }
}
