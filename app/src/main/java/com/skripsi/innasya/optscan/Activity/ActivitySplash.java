package com.skripsi.innasya.optscan.Activity;

/**
 * Created by Anonymous on 09/11/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.skripsi.innasya.optscan.Preference.AppPreparingUsableData;
import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.Reference.resource;
import com.skripsi.innasya.optscan.SQLHelper.SQLHelper;

public class ActivitySplash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    AppPreparingUsableData preparingUsableData;
    private resource conf;
    private SQLHelper sqlHelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_screen);
//        preparingUsableData = new AppPreparingUsableData(this);
//        preparingUsableData.execute();


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                //preparingUsableData = new AppPreparingUsableData(ActivitySplash.this);
                //preparingUsableData.execute();

                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(ActivitySplash.this,ActivityMain.class);
                ActivitySplash.this.startActivity(mainIntent);
                ActivitySplash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}