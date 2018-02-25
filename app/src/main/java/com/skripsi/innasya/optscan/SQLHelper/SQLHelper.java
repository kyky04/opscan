package com.skripsi.innasya.optscan.SQLHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.skripsi.innasya.optscan.Model.Pestisida;
import com.skripsi.innasya.optscan.R;

import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Innasya Rahmania on 16/04/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {
    public SQLiteDatabase mReadDB;
    public static final String TAG = SQLHelper.class.getSimpleName();

    // All Static variables
    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "OPT_DB";

    public static final String TABLE_OPT = "OPT";
    public static final String TABLE_PESTISIDA = "PESTISIDA";
    public static final String TABLE_PESTISIDA_TANAMAN = "PESTISIDA_TANAMAN";
    public static final String TABLE_PESTISIDA_HAMA = "PESTISIDA_HAMA";

    public static final String KEY_ID_OPT = "_ID_OPT";
    public static final String KEY_LATIN_OPT = "NAMA_LATIN_OPT";
    public static final String KEY_NAMA_OPT = "NAMA_OPT";
    public static final String KEY_DESC_OPT = "DESC_OPT";

    public static final String KEY_ID_PESTISIDA = "_ID_PESTISIDA";
    public static final String KEY_NAMA_PESTISIDA = "NAMA_OPT";
    public static final String KEY_DESC_PESTISIDA = "DESC_OPT";
    public static final String KEY_BAHAN_AKTIF_PESTISIDA = "BA_OPT";
    public static final String KEY_CARA_KERJA_PESTISIDA = "CK_OPT";
    public static final String KEY_TINGKAT_BAHAYA_PESTISIDA = "TB_OPT";
    public static final String KEY_FORGN_ID_OPT = "_ID_OPT";


    public static final String KEY_ID_PESTISIDA_TANAMAN = "_ID_PESTISIDA_TANAMAN";
    public static final String KEY_OPTID_PESTISIDA_TANAMAN = "OPT_ID";
    public static final String KEY_MERK_PESTISIDA_TANAMAN = "MERK_DAGANG";
    public static final String KEY_BAHAN_AKTIF_PESTISIDA_TANAMAN = "BA_OPT";
    public static final String KEY_CARA_KERJA_PESTISIDA_TANAMAN = "CK_OPT";
    public static final String KEY_TINGKAT_BAHAYA_PESTISIDA_TANAMAN = "BH_OPT";

    public Context context;

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        mReadDB = getReadableDatabase();
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_OPT_TABLE = "CREATE TABLE " + TABLE_OPT + "("
//                + KEY_ID_OPT + " INTEGER PRIMARY KEY,"
//                + KEY_NAMA_OPT + " TEXT,"
//                + KEY_LATIN_OPT + " TEXT,"
//                + KEY_DESC_OPT + " TEXT)";
//
//        String CREATE_PESTISIDA_TABLE = "CREATE TABLE " + TABLE_PESTISIDA + "("
//                + KEY_ID_PESTISIDA + " INTEGER PRIMARY KEY," + KEY_NAMA_PESTISIDA + " INTEGER,"
//                + KEY_DESC_PESTISIDA + " TEXT, "+ KEY_BAHAN_AKTIF_PESTISIDA + " TEXT,"
//                + KEY_CARA_KERJA_PESTISIDA + " TEXT," + KEY_TINGKAT_BAHAYA_PESTISIDA + " TEXT,"
//                + KEY_FORGN_ID_OPT + " INTEGER )";

        String CREATE_PESTISIDA_TANAMAN_TABLE = "CREATE TABLE " + TABLE_PESTISIDA_TANAMAN + "("
                + KEY_ID_PESTISIDA_TANAMAN + " INTEGER PRIMARY KEY," + KEY_OPTID_PESTISIDA_TANAMAN + " TEXT,"
                + KEY_MERK_PESTISIDA_TANAMAN + " TEXT, " + KEY_BAHAN_AKTIF_PESTISIDA_TANAMAN + " TEXT,"
                + KEY_CARA_KERJA_PESTISIDA_TANAMAN + " TEXT," + KEY_TINGKAT_BAHAYA_PESTISIDA_TANAMAN + " TEXT"
                + " )";
        String CREATE_PESTISIDA_HAMA_TABLE = "CREATE TABLE " + TABLE_PESTISIDA_HAMA + "("
                + KEY_ID_PESTISIDA_TANAMAN + " INTEGER PRIMARY KEY," + KEY_OPTID_PESTISIDA_TANAMAN + " TEXT,"
                + KEY_MERK_PESTISIDA_TANAMAN + " TEXT, " + KEY_BAHAN_AKTIF_PESTISIDA_TANAMAN + " TEXT,"
                + KEY_CARA_KERJA_PESTISIDA_TANAMAN + " TEXT," + KEY_TINGKAT_BAHAYA_PESTISIDA_TANAMAN + " TEXT"
                + " )";


//        db.execSQL(CREATE_OPT_TABLE);
//        db.execSQL(CREATE_PESTISIDA_TABLE);
        db.execSQL(CREATE_PESTISIDA_TANAMAN_TABLE);
        db.execSQL(CREATE_PESTISIDA_HAMA_TABLE);

        loadPestisidaFromJson(db);
        loadPestisidaHamaFromJson(db);

        Log.d(TAG, "Database telah dibuat");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPT);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PESTISIDA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PESTISIDA_TANAMAN);
        // Create tables again
        onCreate(db);
    }

    private void loadPestisidaFromJson(SQLiteDatabase db) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.pestisida_tanaman);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int crt;

        try {
            crt = inputStream.read();
            while (crt != -1) {
                output.write(crt);
                crt = inputStream.read();
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONArray dataPestisida = new JSONArray(output.toString());
            for (int i = 0; i < dataPestisida.length(); i++) {
                Pestisida c = new Pestisida();
                c.setId(dataPestisida.getJSONObject(i).getString("id"));
                c.setOptId(dataPestisida.getJSONObject(i).getString("opt_id"));
                c.setMerekDagang(dataPestisida.getJSONObject(i).getString("merek_dagang"));
                c.setBahanAktif(dataPestisida.getJSONObject(i).getString("bahan_aktif"));
                c.setCaraKerja(dataPestisida.getJSONObject(i).getString("cara_kerja"));
                c.setBahayaPestisida(dataPestisida.getJSONObject(i).getString("bahaya_pestisida"));
                insertPestisida(db, c);
                Log.d(TAG, c.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "parser error json categories" + e.getMessage());
        }
    }

    private void loadPestisidaHamaFromJson(SQLiteDatabase db) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.pestisidahama);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int crt;

        try {
            crt = inputStream.read();
            while (crt != -1) {
                output.write(crt);
                crt = inputStream.read();
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONArray dataPestisida = new JSONArray(output.toString());
            for (int i = 0; i < dataPestisida.length(); i++) {
                Pestisida c = new Pestisida();
                c.setId(dataPestisida.getJSONObject(i).getString("id"));
                c.setOptId(dataPestisida.getJSONObject(i).getString("opt_id"));
                c.setMerekDagang(dataPestisida.getJSONObject(i).getString("merek_dagang"));
                c.setBahanAktif(dataPestisida.getJSONObject(i).getString("bahan_aktif"));
                c.setCaraKerja(dataPestisida.getJSONObject(i).getString("cara_kerja"));
                c.setBahayaPestisida(dataPestisida.getJSONObject(i).getString("bahaya_pestisida"));
                insertPestisidaHama(db, c);
                Log.d(TAG, c.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "parser error json categories" + e.getMessage());
        }
    }

    public void insertPestisida(SQLiteDatabase db, Pestisida category) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID_PESTISIDA_TANAMAN, Integer.parseInt(category.getId()));
        cv.put(KEY_OPTID_PESTISIDA_TANAMAN, Integer.parseInt(category.getOptId()));
        cv.put(KEY_MERK_PESTISIDA_TANAMAN, category.getMerekDagang());
        cv.put(KEY_BAHAN_AKTIF_PESTISIDA_TANAMAN, category.getBahanAktif());
        cv.put(KEY_CARA_KERJA_PESTISIDA_TANAMAN, category.getCaraKerja());
        cv.put(KEY_TINGKAT_BAHAYA_PESTISIDA_TANAMAN, category.getBahayaPestisida());

        db.insert(TABLE_PESTISIDA_TANAMAN, null, cv);
    }
    public void insertPestisidaHama(SQLiteDatabase db, Pestisida category) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID_PESTISIDA_TANAMAN, Integer.parseInt(category.getId()));
        cv.put(KEY_OPTID_PESTISIDA_TANAMAN, Integer.parseInt(category.getOptId()));
        cv.put(KEY_MERK_PESTISIDA_TANAMAN, category.getMerekDagang());
        cv.put(KEY_BAHAN_AKTIF_PESTISIDA_TANAMAN, category.getBahanAktif());
        cv.put(KEY_CARA_KERJA_PESTISIDA_TANAMAN, category.getCaraKerja());
        cv.put(KEY_TINGKAT_BAHAYA_PESTISIDA_TANAMAN, category.getBahayaPestisida());

        db.insert(TABLE_PESTISIDA_HAMA, null, cv);
    }

    public ArrayList<Pestisida> getAllPestisida() {
        ArrayList<Pestisida> dataPestisida = new ArrayList<Pestisida>();

        Cursor c = mReadDB.rawQuery("SELECT * FROM PESTISIDA_TANAMAN", null);

        if (c.moveToFirst()) {
            do {
                Pestisida pestisida = new Pestisida();
                pestisida.setId(c.getString(0));
                pestisida.setOptId(c.getString(1));
                pestisida.setMerekDagang(c.getString(2));
                pestisida.setBahanAktif(c.getString(3));
                pestisida.setCaraKerja(c.getString(4));
                pestisida.setBahayaPestisida(c.getString(5));
                dataPestisida.add(pestisida);

            } while (c.moveToNext());
        }

        return dataPestisida;
    }

    public ArrayList<Pestisida> getAllPestisidaById(int opt_id) {
        ArrayList<Pestisida> dataPestisida = new ArrayList<Pestisida>();

        Cursor c = mReadDB.rawQuery("SELECT * FROM PESTISIDA_TANAMAN WHERE OPT_ID = " + opt_id, null);

        if (c.moveToFirst()) {
            do {
                Pestisida pestisida = new Pestisida();
                pestisida.setId(c.getString(0));
                pestisida.setOptId(c.getString(1));
                pestisida.setMerekDagang(c.getString(2));
                pestisida.setBahanAktif(c.getString(3));
                pestisida.setCaraKerja(c.getString(4));
                pestisida.setBahayaPestisida(c.getString(5));
                dataPestisida.add(pestisida);

            } while (c.moveToNext());
        }

        return dataPestisida;
    }   public ArrayList<Pestisida> getAllPestisidaHamaById(int opt_id) {
        ArrayList<Pestisida> dataPestisida = new ArrayList<Pestisida>();

        Cursor c = mReadDB.rawQuery("SELECT * FROM PESTISIDA_HAMA WHERE OPT_ID = " + opt_id, null);

        if (c.moveToFirst()) {
            do {
                Pestisida pestisida = new Pestisida();
                pestisida.setId(c.getString(0));
                pestisida.setOptId(c.getString(1));
                pestisida.setMerekDagang(c.getString(2));
                pestisida.setBahanAktif(c.getString(3));
                pestisida.setCaraKerja(c.getString(4));
                pestisida.setBahayaPestisida(c.getString(5));
                dataPestisida.add(pestisida);

            } while (c.moveToNext());
        }

        return dataPestisida;
    }


    public void pushDataPestisida(int id, String nama, String desc, String BA, String CK, String TB, int FORGN_ID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_PESTISIDA, id);
        values.put(KEY_NAMA_PESTISIDA, nama);
        values.put(KEY_DESC_PESTISIDA, desc);
        values.put(KEY_BAHAN_AKTIF_PESTISIDA, BA);
        values.put(KEY_CARA_KERJA_PESTISIDA, CK);
        values.put(KEY_TINGKAT_BAHAYA_PESTISIDA, TB);
        values.put(KEY_FORGN_ID_OPT, FORGN_ID);

        // Inserting Row
        long logger = db.insert(TABLE_PESTISIDA, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "Data pestisida_tanaman telah masuk : " + logger);
    }

    public void pushDataOPT(int id, String nama, String latin, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_OPT, id);
        values.put(KEY_NAMA_OPT, nama);
        values.put(KEY_LATIN_OPT, latin);
        values.put(KEY_DESC_OPT, desc);

        // Inserting Row
        long logger = db.insert(TABLE_OPT, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "Data OPT telah masuk : " + logger);
    }

    public ArrayList<HashMap<String, String>> getAllEntireDataOPT() {

        ArrayList<HashMap<String, String>> gettingData = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_OPT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row

        int x = 0;
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (cursor.isAfterLast() == false) {
                HashMap<String, String> dataOPT = new HashMap<String, String>();
                dataOPT.put(KEY_ID_OPT, cursor.getString(0));
                dataOPT.put(KEY_NAMA_OPT, cursor.getString(1));
                dataOPT.put(KEY_DESC_OPT, cursor.getString(2));

                gettingData.add(dataOPT);
                cursor.moveToNext();

                x++;
            }
        }

        Log.d(TAG, "Jumlah data OPT : " + cursor.getCount());

        cursor.close();
        db.close();

        return gettingData;
    }

    public ArrayList<HashMap<String, String>> getAllEntireDataPestisida() {

        ArrayList<HashMap<String, String>> gettingData = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PESTISIDA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row

        int x = 0;
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (cursor.isAfterLast() == false) {
                HashMap<String, String> dataOPT = new HashMap<String, String>();
                dataOPT.put(KEY_ID_PESTISIDA, cursor.getString(0));
                dataOPT.put(KEY_NAMA_PESTISIDA, cursor.getString(1));
                dataOPT.put(KEY_DESC_PESTISIDA, cursor.getString(2));
                dataOPT.put(KEY_BAHAN_AKTIF_PESTISIDA, cursor.getString(3));
                dataOPT.put(KEY_CARA_KERJA_PESTISIDA, cursor.getString(4));
                dataOPT.put(KEY_TINGKAT_BAHAYA_PESTISIDA, cursor.getString(5));
                dataOPT.put(KEY_FORGN_ID_OPT, cursor.getString(6));

                gettingData.add(dataOPT);
                cursor.moveToNext();

                x++;
            }
        }

        Log.d(TAG, "Jumlah data Pestisida : " + cursor.getCount());

        cursor.close();
        db.close();

        return gettingData;
    }

    public void truncateData() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_OPT, null, null);
        db.delete(TABLE_PESTISIDA, null, null);
        db.close();

        Log.d(TAG, "Semua data pada database OPT telah terhapus !!");
    }
}
