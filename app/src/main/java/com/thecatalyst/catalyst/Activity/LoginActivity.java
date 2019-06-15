package com.thecatalyst.catalyst.Activity;
<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
=======

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import android.util.Log;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.thecatalyst.catalyst.R;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    TextView email_text, password_text, login_title;
    ImageView logo;
    CardView login_card;
    SharedPreferences sharedPreferences;
=======
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.thecatalyst.catalyst.Model.Login;
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email,password;
    TextInputLayout email_text, password_text;
    TextView login_title;
    ImageView logo;
    CardView login_card;
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;
    private Snackbar snackbar;
    private CoordinatorLayout coordinatorLayout;
    private boolean internetConnected=true;
    SharedPreferences sp;

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
        Button login_button = findViewById(R.id.login_button);
        final EditText email=findViewById(R.id.login_username);
        final EditText pass=findViewById(R.id.login_password);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

        Handler h = new Handler();

//        top_curve = (ImageView) findViewById(R.id.top_curve);
        email_text = (EditText) findViewById(R.id.login_username);
        email_text = (TextView) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        password_text = (TextView) findViewById(R.id.login_password);
        logo = (ImageView) findViewById(R.id.logo);
        login_title = (TextView) findViewById(R.id.login_text);
        login_card = (CardView) findViewById(R.id.login_card);
        Button lgn = (Button) findViewById(R.id.login_button);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                email.setFocusable(true);
                password.setFocusable(true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
            }

        }, 5000);

        if (sharedPreferences.getBoolean("logged",false)){
            Intent intent = new Intent(LoginActivity.this,TaskScreenActivity.class);
            startActivity(intent);
            finish();
        }
        lgn.setOnClickListener(v -> {
            String user = email.getText().toString();
            String passw = password.getText().toString();
            if (validateLogin(user,passw)){
                doLogin(user,passw);
                sharedPreferences.edit().putBoolean("logged",true).apply();
                sharedPreferences.edit().putString("Username",user).apply();
                sharedPreferences.edit().putString("Password",passw).apply();
                finish();
            }
        });





//        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
//        top_curve.startAnimation(top_curve_anim);
=======
        sp = getSharedPreferences("login",MODE_PRIVATE);

        Handler h = new Handler();

        email = findViewById(R.id.login_username);
        email_text = findViewById(R.id.loginTextInputLayoutuser);
        password = findViewById(R.id.login_password);
        coordinatorLayout = findViewById(R.id.loginlayout);
        password_text = findViewById(R.id.loginTextInputLayoutpass);
        logo = findViewById(R.id.logo);
        login_title = findViewById(R.id.login_text);
        login_card = findViewById(R.id.login_card);
        Button lgn = findViewById(R.id.login_button);

        h.postDelayed(() -> {
            email.setFocusable(true);
            password.setFocusable(true);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
        }, 5000);

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        password.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        email_text.startAnimation(field_name_anim);
        password_text.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
        login_title.startAnimation(field_name_anim);
        lgn.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

<<<<<<< HEAD
        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equalsIgnoreCase("")||password.getText().toString().equalsIgnoreCase("") ){
                    Toast.makeText(LoginActivity.this,"Please Enter Email or Password Then Try again",Toast.LENGTH_LONG).show();
                }else {
                Intent intent = new  Intent(LoginActivity.this,TaskScreenActivity.class);
                startActivity(intent);}
            }
        });

    }
=======
        if(sp.getBoolean("logged",false)){
            Intent intent = new Intent(LoginActivity.this,TaskScreenActivity.class);
            startActivity(intent);
            finish();
        }

        lgn.setOnClickListener(v -> {
            String user = email.getText().toString();
            String passw = password.getText().toString();
            if (validateLogin(user,passw)){
                doLogin(user,passw);

            }
        });
    }

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
<<<<<<< HEAD
    private void doLogin(final String user,final String pass){


        Intent intent = new Intent(LoginActivity.this,TaskScreenActivity.class);
        intent.putExtra("username", user);
        intent.putExtra("pass",pass);
        startActivity(intent);
    }
=======

    private void doLogin(final String user,final String pass){

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<Login> call = service.login(user,pass);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {
                Login mLoginObject = response.body();
                Log.e("TAG", "onResponseLogin: "+mLoginObject );
                assert mLoginObject != null;
                String status = mLoginObject.getStatus();
                String message = mLoginObject.getMessage();
                Log.e("TAG", "onResponseStaus:"+status);
                Log.e("TAG", "onResponseStaus:"+message);
                if (status.equals("success") || message.equals("logged in!")){

                        Intent intent = new Intent(LoginActivity.this,TaskScreenActivity.class);
                        startActivity(intent);
                    sp.edit().putBoolean("logged",true).apply();
                    sp.edit().putString("Username",user).apply();
                    sp.edit().putString("Password",pass).apply();
                    finish();
                }else if (status.equals("error") || message.equals("incorrect password")){
                    password.setError(message,getResources().getDrawable(R.drawable.icon_error));
                    sp.edit().putBoolean("logged",false).apply();
                }

            }

            @Override
            public void onFailure(@NonNull Call<Login> call, @NonNull Throwable t) {

            }
        });


            }

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
<<<<<<< HEAD




//package com.thecatalyst.catalyst.Activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.thecatalyst.catalyst.R;
//
//public class LoginActivity extends AppCompatActivity {
//
//    ImageView top_curve;
//    EditText email,password;
//    TextView email_text, password_text, login_title;
//    ImageView logo;
//    CardView login_card;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Button login_button = findViewById(R.id.login_button);
//
//        Handler h = new Handler();
//
//        top_curve = (ImageView) findViewById(R.id.top_curve);
//        email = (EditText) findViewById(R.id.email);
//        email_text = (TextView) findViewById(R.id.email_text);
//        password = (EditText) findViewById(R.id.password);
//        password_text = (TextView) findViewById(R.id.password_text);
//        logo = (ImageView) findViewById(R.id.logo);
//        login_title = (TextView) findViewById(R.id.login_text);
//        login_card = (CardView) findViewById(R.id.login_card);
//        Button lgn = (Button) findViewById(R.id.login_button);
//
//        h.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                email.setFocusable(true);
//                password.setFocusable(true);
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
//            }
//
//        }, 5000);
//
//        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
//        top_curve.startAnimation(top_curve_anim);
//
//        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
//        email.startAnimation(editText_anim);
//        password.startAnimation(editText_anim);
//
//        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
//        email_text.startAnimation(field_name_anim);
//        password_text.startAnimation(field_name_anim);
//        logo.startAnimation(field_name_anim);
//        login_title.startAnimation(field_name_anim);
//        lgn.startAnimation(field_name_anim);
//
//        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
//        login_card.startAnimation(center_reveal_anim);
//
//        lgn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, TaskScreenActivity.class));
//            }
//        });
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//}
=======
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
