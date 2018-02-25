package com.skripsi.innasya.optscan.Preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Innasya Rahmania on 19/04/2017.
 */

public class AppSaveImage extends AsyncTask<Void, Void, Void> {

    private String nama;
    private String jenis;
    private String desc;
    private Bitmap gambar;
    private Context context;

    protected AppSaveImage(Context context, String nama, String jenis, String desc, Bitmap gambar){
        this.nama = nama;
        this.jenis = jenis;
        this.desc = desc;
        this.gambar = gambar;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        //new SQLHelper(context).pushDataOPT(nama, jenis, desc, gambar);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Toast.makeText(context, this.nama, Toast.LENGTH_LONG).show();
    }
}
