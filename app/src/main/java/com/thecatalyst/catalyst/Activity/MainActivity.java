package com.thecatalyst.catalyst.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.thecatalyst.catalyst.R;
import com.crashlytics.android.Crashlytics;

import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        img_logo = (ImageView) findViewById(R.id.main_logo);

        Animation reveal_logo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.main_logo_anim);
        img_logo.startAnimation(reveal_logo);

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.INTERNET,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {

                handler.postDelayed(() -> {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Log.e("TAG", "run: ");
                    finish();
                }, 1000);

            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(error -> {

            Toast.makeText(this,"Internet Permission Required",Toast.LENGTH_SHORT).show();
        }).check();

    }
}
