package com.skripsi.innasya.optscan.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.skripsi.innasya.optscan.Camera.CameraActivity;
import com.skripsi.innasya.optscan.Camera.ImageUtility;
import com.skripsi.innasya.optscan.Preference.AppDialogProcessBox;
import com.skripsi.innasya.optscan.R;
import com.skripsi.innasya.optscan.Reference.ImageBitmap;

import java.io.InputStream;
import java.lang.reflect.Array;


public class ActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private Point mSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton fab = (ImageButton) findViewById(R.id.fab);

        Display display = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permission();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void permission(){
        final String permission = Manifest.permission.CAMERA;
        if (ContextCompat.checkSelfPermission(ActivityMain.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(ActivityMain.this, permission)) {
                showPermissionRationaleDialog("Izinkan Aplikasi OPTScan untuk memulai akses Kamera", permission);
            } else {
                requestForPermission(permission);
            }
        } else {
            showDialogPilihan();
        }
    }

    //menampilkan pilihan kamera atau dari file
    private void showDialogPilihan(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] pilihan = {"Import File","Kamera"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,pilihan);
        builder.setTitle("Pilihan");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0 :
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Ambil Gambar"), PICK_IMAGE_REQUEST);
                        break;
                    case 1:
                        launch();
                        break;
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //HASIL IMPORT DAN REKAM KAMERA ================================================================
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;

        try{
            if (requestCode == REQUEST_CAMERA) {
                Uri photoUri = data.getData();
                // Get the bitmap in according to the width of the device
                Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(photoUri.getPath(), mSize.x, mSize.x);

                ImageBitmap resImg = new ImageBitmap();
                resImg.setImageBitmap(bitmap);

                Intent activity = new Intent(ActivityMain.this,ActivityReview.class);
                ActivityMain.this.startActivity(activity);

            }else if(requestCode == PICK_IMAGE_REQUEST){
                Uri selectedImage = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                Bitmap imageConverted = BitmapFactory.decodeStream(imageStream);

                AppDialogProcessBox DialogProcessBox = new AppDialogProcessBox(ActivityMain.this , imageConverted);
                DialogProcessBox.show();
            }
        }catch (Exception e){
            Toast.makeText(ActivityMain.this, "File Gambar Tidak Ditemukan !!" , Toast.LENGTH_LONG).show();
        }

    }

    private void showPermissionRationaleDialog(final String message, final String permission) {
        new AlertDialog.Builder(ActivityMain.this)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityMain.this.requestForPermission(permission);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    private void requestForPermission(final String permission) {
        ActivityCompat.requestPermissions(ActivityMain.this, new String[]{permission,Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA_PERMISSION);
    }

    private void launch() {
        Intent startCustomCameraIntent = new Intent(this, CameraActivity.class);
        startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION:
                final int numOfRequest = grantResults.length;
                final boolean isGranted = numOfRequest == 1
                        && PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
                if (isGranted) {
                    showDialogPilihan();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //Import Gambar
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Ambil Gambar"), PICK_IMAGE_REQUEST);
        } else if (id == R.id.nav_gallery) {
            //Informasi
            Intent intent = new Intent(ActivityMain.this, ActivityInformasi.class);
            startActivity(intent);
        }else if (id == R.id.nav_penyakit) {
            //Kelompok
            Intent intent = new Intent(ActivityMain.this, ActivityKelompok.class);
            startActivity(intent);
        }else if (id == R.id.nav_about) {
            //Tentang
            Intent intent = new Intent(ActivityMain.this, ActivityAbout.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
