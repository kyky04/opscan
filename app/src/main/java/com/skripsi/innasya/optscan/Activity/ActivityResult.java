package com.skripsi.innasya.optscan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.Reference.resource;

public class ActivityResult extends AppCompatActivity {

    private int index = 0;
    private resource res = new resource(ActivityResult.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        index = extras.getInt("index");

        TextView namaOPT = (TextView) findViewById(R.id.namaOPT);
        TextView latin = (TextView) findViewById(R.id.nama_latin);
        TextView desc = (TextView) findViewById(R.id.desc);

        ImageView bckgrnd = (ImageView)  findViewById(R.id.foto_informasi);

        namaOPT.setText(res.getDataRowOPT()[index][1]);
        latin.setText(res.getDataRowOPT()[index][2]);
        desc.setText(res.getDataRowOPT()[index][3]);

        bckgrnd.setBackgroundResource(res.getGambarDataRowOPT()[index]);

        FloatingActionButton pestButton = (FloatingActionButton) findViewById(R.id.pest_button);
        pestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityResult.this,ActivityPestisida.class);
                intent.putExtra("posisi", index);
                ActivityResult.this.startActivity(intent);
            }
        });

    }
}
