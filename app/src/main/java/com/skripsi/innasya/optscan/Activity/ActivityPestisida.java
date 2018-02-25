package com.skripsi.innasya.optscan.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.skripsi.innasya.optscan.Preference.AppDialogExceptional;
import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.Reference.resource;


public class ActivityPestisida extends AppCompatActivity {

    private resource conf;
    private TextView judul_atas , judul_bawah;
    private AppDialogExceptional detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestisida);

        conf = new resource(ActivityPestisida.this);

        Bundle extras = getIntent().getExtras();
        final int posisi = extras.getInt("posisi");

        String string_judul_atas = "Pestisida Pertanian dan Kehutanan Direktorat pupuk dan pestisidahama " +
                "\nDirektorat Jendral Prasarana dan Sarana Pertanian " +
                "\nKementrian Pertanian Republik Indonesia";

        String string_judul_bawah = "Pestisida Komoditas Bawang Merah \nNama Umum OPT : "
                + conf.getDataRowOPT()[posisi][1] + "\nKlik pada pestisidahama untuk "
                + "memperoleh informasi detail pestisidahama";

        judul_atas = (TextView)findViewById(R.id.judul_atas);
        judul_bawah = (TextView)findViewById(R.id.judul_bawah);

        judul_atas.setText(string_judul_atas);
        judul_bawah.setText(string_judul_bawah);

        TableLayout tl = (TableLayout)findViewById(R.id.table);

        TableRow trd = new TableRow(this);

        TextView nmd = new TextView(this);
        TextView bad = new TextView(this);

        nmd.setText("Merk Dagang");
        bad.setText("Bahan Aktif");

        nmd.setTypeface(Typeface.DEFAULT_BOLD);
        bad.setTypeface(Typeface.DEFAULT_BOLD);

        nmd.setHeight(90);
        bad.setHeight(90);
        nmd.setWidth(330);
        bad.setWidth(500);

        trd.addView(nmd);
        trd.addView(bad);
        tl.addView(trd ,
                new TableLayout.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT
                )
        );

        for(int x = 0; x < conf.getDataRowPestisida().length; x++){
            if((posisi + 1) == Integer.parseInt(conf.getDataRowPestisida()[x][6])){
                TableRow tr = new TableRow(this);

                TextView nm = new TextView(this);
                TextView ba = new TextView(this);

                nm.setHeight(90);
                ba.setHeight(90);

                nm.setTypeface(Typeface.DEFAULT_BOLD);

                nm.setTextSize(10);
                ba.setTextSize(10);

                nm.setText(conf.getDataRowPestisida()[x][1]);
                ba.setText(conf.getDataRowPestisida()[x][2]);

                tr.addView(nm);
                tr.addView(ba);
                tl.addView(tr ,
                        new TableLayout.LayoutParams(
                                TableRow.LayoutParams.MATCH_PARENT,
                                TableRow.LayoutParams.MATCH_PARENT
                        )
                );
            }
        }
    }
}
