package com.skripsi.innasya.optscan.Metode.Histogram;

/**
 * Created by Anonymous on 09/01/2018.
 */

public class CumulativeHisto {

    //MEAN
    public double mean(double [] val){
        double result = 0;

        for(int x = 0; x < val.length; x++){
            result += (x * val[x]);
        }

        return result;
    }

    //Variansi
    public double variance(double [] val , double mean){
        double result = 0;

        for(int x = 0; x < val.length; x++){
            result += Math.pow((x - mean),2) * val[x];
        }

        return result;
    }

    //Skewness
    public double skewness(double [] val , double mean){
        double result = 0;

        for(int x = 0; x < val.length; x++){
            result += Math.pow((x - mean),3) * val[x];
        }

        return result;
    }

    //Kurtosis
    public double kurtosis(double [] val , double mean){
        double result = 0;

        for(int x = 0; x < val.length; x++){
            result += Math.pow((x - mean),4) * val[x];
        }

        return result;
    }

    //Entropy
    public double entropy(double [] val){
        double result = 0;

        for(int x = 0; x < val.length; x++){
            result += (val[x] * Math.log(val[x]));
        }

        return Math.abs(result);
    }

}
