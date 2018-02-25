package com.skripsi.innasya.optscan.Metode.Histogram;

import com.skripsi.innasya.optscan.Reference.resource;

import java.util.Arrays;

/**
 * Created by Anonymous on 08/01/2018.
 */

public class MeanFreq {

    public double [] generalExec(int [] freq , int pixelSize){
        int yunik [] = unique_array(freq);
        double intencityFreq [];

        intencityFreq = new double[yunik.length];

        for(int x = 0; x < yunik.length; x++){
            for(int y = 0; y < freq.length; y++){
                if(yunik[x] == freq[y]){
                    intencityFreq[x] += 1;
                }
            }
        }

        System.out.print("UKURAN PIXEL : "+pixelSize+"\n");

        double intencityFreq_result [] = new double[intencityFreq.length];

        for(int x = 0; x < intencityFreq.length; x++){
            intencityFreq_result[x] = (((double)1)/Math.pow(((double)pixelSize),2)) * intencityFreq[x];
            System.out.print("Freq : "+intencityFreq_result[x]+"\n");
        }

        return intencityFreq_result;
    }

    public int [] unique_array(int [] color) {

        int no_unique_elements = color.length;

        for (int i = 0; i < no_unique_elements; i++) {
            for (int j = i+1; j < no_unique_elements; j++) {
                if(color[i] == color[j]) {

                    //Replace duplicate element with last unique element
                    color[j] = color[no_unique_elements-1];
                    no_unique_elements--;

                    j--;
                }
            }
        }

        int[] unique = Arrays.copyOf(color, no_unique_elements);

        return unique;

    }
}
