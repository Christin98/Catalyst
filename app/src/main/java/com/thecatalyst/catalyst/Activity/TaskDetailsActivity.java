package com.thecatalyst.catalyst.Activity;

<<<<<<< HEAD
=======
import androidx.annotation.NonNull;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.thecatalyst.catalyst.R;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.util.Calendar;
import java.util.Date;

public class TaskDetailsActivity extends AppCompatActivity {

    Button submit_project;
    AlertDialog.Builder builder;
=======
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.thecatalyst.catalyst.Model.RetroUsers;
import com.thecatalyst.catalyst.Model.Technology;
import com.thecatalyst.catalyst.Network.RetrofitClient;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskDetailsActivity extends AppCompatActivity {
    AlertDialog builder;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
<<<<<<< HEAD
        TextView projectname = findViewById(R.id.project_name_dialog);
        TextView startdate = findViewById(R.id.start_date_dialog);
        TextView endDate = findViewById(R.id.end_date_dialog);
        TextView details = findViewById(R.id.details_dialog);

        Intent intent = getIntent();

        projectname.setText(intent.getStringExtra("Name"));
        startdate.setText(intent.getStringExtra("StartDate"));
        endDate.setText(intent.getStringExtra("EndDate"));
        details.setText(intent.getStringExtra("Details"));

        submit_project = (Button) findViewById(R.id.submit_project);
        builder = new AlertDialog.Builder(this);
        submit_project.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title)
                        .setCancelable(false)

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Your project submitted to Admin",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
//                                Toast.makeText(getApplicationContext(), "",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
//                alert.setTitle("AlertDialogExample");
                alert.show();

                Intent intent = getIntent();
                projectname.setText(intent.getStringExtra("Name"));
                startdate.setText(intent.getStringExtra("StartDate"));
                endDate.setText(intent.getStringExtra("EndDate"));
                details.setText(intent.getStringExtra("Details"));
            }
        });
    }
}
=======
        TextView pro_name = findViewById(R.id.project_name);
        TextView startd = findViewById(R.id.startd);
        TextView endd = findViewById(R.id.endd);
        TextView remday = findViewById(R.id.remd);
        TextView detail = findViewById(R.id.detailtv);
        LinearLayout task_project = findViewById(R.id.task_lay_project);
        LinearLayout task_date = findViewById(R.id.task_lay_date);
        LinearLayout task_mem = findViewById(R.id.task_lay_mem);
        LinearLayout task_details = findViewById(R.id.task_lay_details);
        Button button = findViewById(R.id.submit_project);
        Spinner memberSp = findViewById(R.id.spinner1);
        Spinner techSp = findViewById(R.id.spinner2);
        ArrayList<String> tech;
        ArrayList<String> tmember ;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Date date;
        Date date1;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();



        Intent intent = getIntent();

        String name = intent.getStringExtra("Name");
        String startdt = intent.getStringExtra("StartDate");
        String enddt = intent.getStringExtra("EndDate");
        String remdy = intent.getStringExtra("Rem");
        String details = intent.getStringExtra("Details");
        int index = intent.getIntExtra("Index", 0);

        button.setOnClickListener(v -> builder = new AlertDialog.Builder(TaskDetailsActivity.this)
                .setCancelable(false)
                .setMessage("Are You sure?")
                .setTitle("Submit Project")
                .setPositiveButton("Yes", (dialog, which) -> {
                    finish();
                    Toast.makeText(TaskDetailsActivity.this,"Submitted",Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.cancel())
        .show());


        tech = new ArrayList<>();
        tmember = new ArrayList<>();

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<RetroUsers> call = service.getApk(0);

        call.enqueue(new Callback<RetroUsers>() {

            @Override
            public void onResponse(@NonNull Call<RetroUsers> call, @NonNull Response<RetroUsers> response) {
                assert response.body() != null;
                String s1 = response.body().getData().get(index).getAllTeamMembers();
                String s2 = response.body().getData().get(index).getAllTechnology();
                String[] s = s1.split(",");
                String[] st = s2.split(",");
                tech.addAll(Arrays.asList(s).subList(0, s.length + 1));
                tmember.addAll(Arrays.asList(st).subList(0,st.length + 1));
                techSp.setAdapter(new ArrayAdapter<>(TaskDetailsActivity.this, android.R.layout.simple_spinner_dropdown_item, tech));
                memberSp.setAdapter(new ArrayAdapter<>(TaskDetailsActivity.this, android.R.layout.simple_spinner_dropdown_item, tmember));
            }

            @Override
            public void onFailure(@NonNull Call<RetroUsers> call, @NonNull Throwable throwable) {
                Toast.makeText(TaskDetailsActivity.this, "Error to load Member List", Toast.LENGTH_SHORT).show();
            }
        });

        techSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country= techSp.getItemAtPosition(techSp.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        pro_name.setText(name);
        startd.setText(startdt);
        endd.setText(enddt);
        remday.setText(remdy);
        detail.setText(details);
//        task_project.setBackgroundColor(Color.parseColor("#"+color));
//        task_date.setBackgroundColor(Color.parseColor("#"+color));
//        task_mem.setBackgroundColor(Color.parseColor("#"+color));
//        task_details.setBackgroundColor(Color.parseColor("#"+color));

    }
}
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
