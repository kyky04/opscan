package com.skripsi.innasya.optscan.Preference;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.skripsi.innasya.optscan.Metode.Detection;
import com.skripsi.innasya.optscan.R;

import java.util.ArrayList;

/**
 * Created by Innasya Rahmania on 18/04/2017.
 */
public class AppDialogProcessBox extends Dialog {

    public Activity activity;
    public Bitmap image;
    public Button batal;

    private CheckBox ck0 , ck1, ck2 , ck3 , ck4 , ck5,ck6,ck7;

    public AppDialogProcessBox(Activity a , Bitmap image) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        this.image = image;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_proses);

        ck0 = (CheckBox)findViewById(R.id.ck0);
        ck1 = (CheckBox)findViewById(R.id.ck1);
        ck2 = (CheckBox)findViewById(R.id.ck2);
        ck3 = (CheckBox)findViewById(R.id.ck3);
        ck4 = (CheckBox)findViewById(R.id.ck4);
        ck5 = (CheckBox)findViewById(R.id.ck5);
        ck6 = (CheckBox)findViewById(R.id.ck6);
        ck7 = (CheckBox)findViewById(R.id.ck7);

        batal = (Button) findViewById(R.id.batal);

        int data = 0;
        ck0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 1;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 2;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 3;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 4;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 5;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 6;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 7;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });ck7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int data = 8;
                new Detection(activity , image , data).execute();
                dismiss();
            }
        });
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
