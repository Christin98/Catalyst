package com.thecatalyst.catalyst.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
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