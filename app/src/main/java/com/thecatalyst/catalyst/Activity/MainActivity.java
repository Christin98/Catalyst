package com.thecatalyst.catalyst.Activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
<<<<<<< HEAD
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
=======
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import android.widget.ImageView;

import com.thecatalyst.catalyst.R;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_logo = (ImageView) findViewById(R.id.main_logo);

//        Animation reveal_logo = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_logo_anim);
//        img_logo.startAnimation(reveal_logo);

<<<<<<< HEAD
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Log.e("TAG", "run: " );
                finish();
            }
=======
        handler.postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            Log.e("TAG", "run: " );
            finish();
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        },1000);
    }
}
