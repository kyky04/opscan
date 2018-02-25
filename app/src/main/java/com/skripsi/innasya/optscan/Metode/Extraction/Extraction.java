package com.skripsi.innasya.optscan.Metode.Extraction;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.skripsi.innasya.optscan.Preference.AppDialogProgressBox;

/**
 * Created by Innasya Rahmania on 26/04/2017.
 */

public class Extraction {

    int [] Rfreq;
    int [] Gfreq;
    int [] Bfreq;

    public void ExtractToPix (Bitmap bitmap , final String Status){

        Rfreq = new int[256];
        Gfreq = new int[256];
        Bfreq = new int[256];

        int picw = bitmap.getWidth();
        int pich = bitmap.getHeight();

        int rcolor = 0;
        int gcolor = 0;
        int bcolor = 0;

        double [][][] img = new double[picw][pich][3];

        Log.d("EXTRAKSI GAMBAR " , Status);

        for (int x = 0; x < pich; x++){

            for (int y = 0; y < picw; y++)
            {
                int mPixel = bitmap.getPixel(x,y);

                rcolor = (mPixel >> 16) & 0xff;
                gcolor = (mPixel >> 8) & 0xff;
                bcolor = (mPixel >> 0) & 0xff;

                Rfreq[rcolor]++;
                Gfreq[gcolor]++;
                Bfreq[bcolor]++;

            }
        }

        for(int i = 0; i < Rfreq.length; i++){
            Log.d("FREQ R-G-B "+Status , String.valueOf(Rfreq[i]+" - "+Gfreq[i]+" - "+ Bfreq[i]));
        }
    }

    public int [] getRedFreq(){
        return Rfreq;
    }

    public int [] getGreenFreq(){
        return Gfreq;
    }

    public int [] getBlueFreq(){
        return Bfreq;
    }

}
