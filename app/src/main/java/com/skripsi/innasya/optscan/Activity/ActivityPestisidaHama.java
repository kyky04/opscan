package com.skripsi.innasya.optscan.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.skripsi.innasya.optscan.Adapter.AdapterPestisida;
import com.skripsi.innasya.optscan.Model.Pestisida;
import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.SQLHelper.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class ActivityPestisidaHama extends AppCompatActivity {
    SQLHelper sqlHelper;
    RecyclerView rvPestisida;
    AdapterPestisida adapter;
    List<Pestisida> pestisidaList;

    private TextView judul_atas , judul_bawah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestisida_tanaman);
        sqlHelper = new SQLHelper(this);

        int opt_id = getIntent().getIntExtra("opt_id", 0);
        int id= 0;
        String string_judul_atas = "Pestisida Pertanian dan Kehutanan Direktorat pupuk dan pestisida_tanaman " +
                "\nDirektorat Jendral Prasarana dan Sarana Pertanian " +
                "\nKementrian Pertanian Republik Indonesia";


        String[] judul = {"Ulat Tanah","Uret","Orong - Orong ","Ulat Bawang","Lalat Penggorok Daun","Kutu Daun Bawang","Tripis","Ulat Grayak"};
        String string_judul_bawah = "Pestisida Komoditas Bawang Merah \nNama Umum OPT : "
                + judul[opt_id] ;

        if(opt_id == 0){
            id = 1;
        }else if(opt_id == 1){
            id = 2;
        }else if(opt_id == 2){
            id = 3;
        }else if(opt_id == 3){
            id = 4;
        }else if(opt_id == 4){
            id = 5;
        }else if(opt_id == 5){
            id = 6;
        }else if(opt_id == 6){
            id = 7;
        }else if(opt_id == 7){
            id = 8;
        }
        rvPestisida = (RecyclerView) findViewById(R.id.recycler_pestisida);
        judul_atas = (TextView)findViewById(R.id.judul_atas);
        judul_bawah = (TextView)findViewById(R.id.judul_bawah);



        judul_atas.setText(string_judul_atas);
        judul_bawah.setText(string_judul_bawah);
        pestisidaList = new ArrayList<>();
        for (Pestisida p : sqlHelper.getAllPestisidaHamaById(id)) {
            pestisidaList.add(p);
        }
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPestisida.setLayoutManager(llm);
        adapter = new AdapterPestisida(this,pestisidaList);
        rvPestisida.setAdapter(adapter);
    }
}
