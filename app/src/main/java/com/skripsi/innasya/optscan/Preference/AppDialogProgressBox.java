package com.skripsi.innasya.optscan.Preference;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.skripsi.innasya.optscan.R;

/**
 * Created by Innasya Rahmania on 18/04/2017.
 */
public class AppDialogProgressBox extends Dialog {

    public Context activity;
    public Bitmap bitmap;
    public static TextView progressDetail;

    public AppDialogProgressBox(Context a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_progress);

        progressDetail = (TextView)findViewById(R.id.progressDetail);
    }
}


