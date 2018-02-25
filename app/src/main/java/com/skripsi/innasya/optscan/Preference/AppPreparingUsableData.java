package com.skripsi.innasya.optscan.Preference;

/**
 * Created by Innasya Rahmania on 20/04/2017.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.skripsi.innasya.optscan.Reference.resource;
import com.skripsi.innasya.optscan.SQLHelper.SQLHelper;

public class AppPreparingUsableData extends AsyncTask<Void, Void, Void> {
    private Context context;
    private resource conf;
    private SQLHelper SQL;
    private AppDialogProgressBox AppDialogProgressBox;

    public AppPreparingUsableData(Context context){
        this.context = context;
        this.conf = new resource(context);
        this.SQL = new SQLHelper(context);
        this.AppDialogProgressBox = new AppDialogProgressBox(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        AppDialogProgressBox.setCancelable(false);
        AppDialogProgressBox.setCanceledOnTouchOutside(false);

        AppDialogProgressBox.show();
        AppDialogProgressBox.progressDetail.setText("Menyiapkan Data...");

    }

    @Override
    protected Void doInBackground(Void... arg0) {
        SQL.truncateData();
        for(int x = 0; x < conf.dataRowPestisida.length; x++){
            SQL.pushDataPestisida(
                    Integer.valueOf(conf.getDataRowPestisida()[x][0]),
                    conf.getDataRowPestisida()[x][1],
                    conf.getDataRowPestisida()[x][2],
                    conf.getDataRowPestisida()[x][3],
                    conf.getDataRowPestisida()[x][4],
                    conf.getDataRowPestisida()[x][5],
                    Integer.valueOf(conf.getDataRowPestisida()[x][6])
            );

            SQL.pushDataOPT(
                    Integer.valueOf(conf.getDataRowOPT()[x][0]),
                    conf.getDataRowOPT()[x][1],
                    conf.getDataRowOPT()[x][2],
                    conf.getDataRowOPT()[x][3]
            );

            System.out.println("Data OPT "+conf.getDataRowPestisida()[x][1]+" Dimasukan");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        Toast.makeText(context, "Selesai Menyiapkan Data!" , Toast.LENGTH_LONG).show();

    }


}