package com.skripsi.innasya.optscan.Activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.skripsi.innasya.optscan.R;


public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView penyusun = (TextView)findViewById(R.id.penyusun);
        TextView pengembang = (TextView)findViewById(R.id.pengembang);
        TextView versi = (TextView)findViewById(R.id.versioning);

        penyusun.setText("Pembimbing I\t: Icsan Taufik, ST., MT.\n" +
                "Pembimbing II\t: Yana Aditia Gerhana, ST., M.Kom.\n" +
                "Pembimbing Instansi\t:  Ir. Tonny Koestoni Moekasan\n" +
                "Penulis : Innasya Rahmania");

        pengembang.setText("Innasya Rahmania (Mahasiswi UIN SGD Bandung)\n" +
                "Email\t: innasya.07@gmail.com.");

        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versi.setText("Versi "+packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
