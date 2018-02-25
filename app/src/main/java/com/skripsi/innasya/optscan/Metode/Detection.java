package com.skripsi.innasya.optscan.Metode;

/**
 * Created by Innasya Rahmania on 20/04/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.DecimalFormat;
import android.os.AsyncTask;
import android.util.Log;

import com.skripsi.innasya.optscan.Activity.ActivityResult;
import com.skripsi.innasya.optscan.Metode.Extraction.Extraction;
import com.skripsi.innasya.optscan.Metode.Extraction.ImagePreProcessing;
import com.skripsi.innasya.optscan.Metode.Histogram.CumulativeHisto;
import com.skripsi.innasya.optscan.Metode.Histogram.MeanFreq;
import com.skripsi.innasya.optscan.Metode.KNearestNeighbour.NearestNeigbour;
import com.skripsi.innasya.optscan.Preference.AppDialogExceptional;
import com.skripsi.innasya.optscan.Preference.AppDialogProgressBox;
import com.skripsi.innasya.optscan.Preference.AppResizeImage;
import com.skripsi.innasya.optscan.Reference.resource;

import java.util.Arrays;


public class Detection extends AsyncTask<Void, Void, Void> {
    private Activity context;
    private Bitmap bitmap;
    private AppDialogProgressBox AppDialogProgressBox;

    private resource resOPT;

    private double min;

    private int index = 99999999;
    private int indikasiTanaman;

    private double SquareDistance [];
    //construktor detection
    public Detection(Activity context, Bitmap bitmap, int indikasiTanaman){
        this.context = context;
        this.bitmap = bitmap;
        this.indikasiTanaman = indikasiTanaman;
        this.AppDialogProgressBox = new AppDialogProgressBox(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        AppDialogProgressBox.setCancelable(false);
        AppDialogProgressBox.setCanceledOnTouchOutside(false);
        AppDialogProgressBox.show();

        AppDialogProgressBox.progressDetail.setText("Mendeteksi Data...");

    }

    @Override
    protected Void doInBackground(Void... arg0) {

        CumulativeHisto Hist = new CumulativeHisto();
        MeanFreq mean = new MeanFreq();
        Extraction Ext = new Extraction();
        NearestNeigbour Near = new NearestNeigbour();

        resOPT = new resource(context);

        double freqColor [][] = new double[3][];

        double MeanTest [] = new double[3];
        double varianceTest [] = new double[3];
        double skewnessTest [] = new double[3];
        double kurtosisTest [] = new double[3];
        double entropyTest [] = new double[3];

        double MeanLatih [][] = new double[resOPT.getDataLatihSatu().size()][3];
        double varianceLatih [][] = new double[resOPT.getDataLatihSatu().size()][3];
        double skewnessLatih [][] = new double[resOPT.getDataLatihSatu().size()][3];
        double kurtosisLatih [][] = new double[resOPT.getDataLatihSatu().size()][3];
        double entropyLatih [][] = new double[resOPT.getDataLatihSatu().size()][3];

        this.bitmap = new AppResizeImage().getResizeImage(bitmap , resOPT.pixelSize() , resOPT.pixelSize());
        //ektract gambar
        Ext.ExtractToPix(this.bitmap , "Data Test");

        freqColor[0] = mean.generalExec(Ext.getRedFreq() , resOPT.pixelSize());
        freqColor[1] = mean.generalExec(Ext.getGreenFreq() , resOPT.pixelSize());
        freqColor[2] = mean.generalExec(Ext.getBlueFreq() , resOPT.pixelSize());


        //EKSTRAKSI CIRI DATA TES
        for(int x = 0; x < 3; x++){
            MeanTest[x] = Hist.mean(freqColor[x]);

            varianceTest[x] = Hist.variance(freqColor[x] , MeanTest [x]);
            skewnessTest[x] = Hist.skewness(freqColor[x] , MeanTest [x]);
            kurtosisTest[x] = Hist.kurtosis(freqColor[x] , MeanTest [x]);

            entropyTest[x] = Hist.entropy(freqColor[x]);
        }


        //EKSTRAKSI CIRI DATA LATIH SATU
        for(int x = 0; x < resOPT.getDataLatihSatu().size(); x++){

            this.bitmap = new AppResizeImage().getResizeImage(
                    resOPT.getDataLatihSatu().get(x),
                    resOPT.pixelSize(),
                    resOPT.pixelSize()
            );

            Ext.ExtractToPix(this.bitmap , "Data Latih "+(x+1));

            freqColor[0] = mean.generalExec(Ext.getRedFreq() , resOPT.pixelSize());
            freqColor[1] = mean.generalExec(Ext.getGreenFreq() , resOPT.pixelSize());
            freqColor[2] = mean.generalExec(Ext.getBlueFreq() , resOPT.pixelSize());

            for(int y = 0; y < 3; y++){
                MeanLatih[x][y] = Hist.mean(freqColor[y]);

                varianceLatih[x][y] = Hist.variance(freqColor[y] , MeanLatih [x][y]);
                skewnessLatih[x][y] = Hist.skewness(freqColor[y] , MeanLatih [x][y]);
                kurtosisLatih[x][y] = Hist.kurtosis(freqColor[y] , MeanLatih [x][y]);

                entropyLatih[x][y] = Hist.entropy(freqColor[y]);
            }
        }
        //kerapatan
        SquareDistance = new double[resOPT.getDataLatihSatu().size()];

        for(int x = 0; x < resOPT.getDataLatihSatu().size(); x++){
            SquareDistance [x] = Near.getSquareDistance(
                    MeanTest , varianceTest , skewnessTest , kurtosisTest , entropyTest ,
                    MeanLatih[x] , varianceLatih[x], skewnessLatih[x] , kurtosisLatih[x] , entropyLatih[x] ,
                    context
            );
        }

        double cloneArrayDistance [] = SquareDistance.clone();
        //pengurutan hasil
        Arrays.sort(cloneArrayDistance);

        for(int x = 0; x < SquareDistance.length; x++){
            Log.d("Distance Sort" , String.valueOf(cloneArrayDistance[x]));
        }

        min = SquareDistance[0];
        for(int x = 0; x < SquareDistance.length; x++){
            Log.d("Distance" , String.valueOf(SquareDistance[x]));
            if(cloneArrayDistance[0] == SquareDistance[x]){
                index = x;
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        //indikasi dan index
        if((indikasiTanaman == 1) && index == 0){
            AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else if((indikasiTanaman == 2) && (index == 1)){
            AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else if((indikasiTanaman == 3) && (index == 2)){
            AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else if((indikasiTanaman == 6) && (index == 3)){
            AppDialogProgressBox.dismiss();AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else if((indikasiTanaman == 5) && (index == 4)){
            AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else if((indikasiTanaman == 4) && (index == 5)){
            AppDialogProgressBox.dismiss();
            Intent activity = new Intent(context , ActivityResult.class);
            activity.putExtra("index", index);
            context.startActivity(activity);
        }else{
            new AppDialogExceptional(context, index , min).show();
            AppDialogProgressBox.dismiss();
        }
    }
}