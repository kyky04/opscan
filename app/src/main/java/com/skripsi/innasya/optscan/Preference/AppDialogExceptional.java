package com.skripsi.innasya.optscan.Preference;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.Reference.resource;

/**
 * Created by Innasya Rahmania on 18/04/2017.
 */
public class AppDialogExceptional extends Dialog {

    private Activity activity;
    private Bitmap image;
    private Button batal;
    private TextView except;
    private resource con;
    private int index;
    private double min;

    public AppDialogExceptional(Activity a, int index , double min) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        this.con = new resource(a);
        this.index = index;
        this.min = min;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_exception);

        Log.d("Index" , String.valueOf(index)+" NILAI : "+String.valueOf(min));

        if(index != 99999999){
            except = (TextView)findViewById(R.id.except);

            except.setText("Objek teridentifikasi melalui citra adalah OPT "+con.getDataRowOPT()[this.index][1]
                    +" namun indikasi yang tanaman anda alami, tidak sesuai dengan sifat-sifat pada " +
                    "OPT "+con.getDataRowOPT()[this.index][1]+". Dimungkinkan anda sedang mengidentifikasi OPT lain."

            );
        }else{
            except = (TextView)findViewById(R.id.except);

            except.setText("Gagal Mendeteksi !!");
        }


        batal = (Button) findViewById(R.id.batal);

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
