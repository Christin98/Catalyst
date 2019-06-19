package com.thecatalyst.catalyst.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.thecatalyst.catalyst.Model.Login;
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email,password;
    TextInputLayout email_text, password_text;
    TextView login_title;
    ImageView logo;
    CardView login_card;
    SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("login",MODE_PRIVATE);


        Handler h = new Handler();

        email = findViewById(R.id.login_username);
        email_text = findViewById(R.id.loginTextInputLayoutuser);
        password = findViewById(R.id.login_password);
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

    private void doLogin(final String user,final String pass){
        Log.e("TAG", "CLICKED: " );

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
                Log.e("TAG", "onFailure: "+t );
            }
        });


            }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
