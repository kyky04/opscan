package com.skripsi.innasya.optscan.Metode.KNearestNeighbour;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.skripsi.innasya.optscan.Preference.AppDialogProgressBox;
import com.skripsi.innasya.optscan.Reference.resource;

/**
 * Created by Innasya Rahmania on 22/04/2017.
 */

public class NearestNeigbour {


    public double getSquareDistance(
            double [] MeanTest , double [] varianceTest , double [] skewnessTest , double [] kurtosisTest , double [] entropyTest ,
            double [] MeanLatih , double [] varianceLatih , double [] skewnessLatih , double [] kurtosisLatih , double [] entropyLatih ,
            Activity context
    ) {

        double rataDist [] = new double[3];
        double distance = 0;

        for (int x = 0; x < (MeanTest.length-1); x++) {
            rataDist [x] = (Math.pow((MeanTest[x] - MeanLatih[x]),2)
                    + Math.pow((varianceTest[x] - varianceLatih[x]),2)
                    + Math.pow((skewnessTest[x] - skewnessLatih[x]),2)
                    + Math.pow((kurtosisTest[x] - kurtosisLatih[x]),2)
                    + Math.pow((entropyTest[x] - entropyLatih[x]),2)) / 5.0;
        }

        for (int x = 0; x < rataDist.length; x++) {
            distance += Math.sqrt(rataDist[x]);
        }

        return distance / rataDist.length;
    }
}