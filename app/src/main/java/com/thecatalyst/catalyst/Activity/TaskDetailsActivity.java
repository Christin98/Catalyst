package com.thecatalyst.catalyst.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.molo17.customizablecalendar.library.components.CustomizableCalendar;
import com.molo17.customizablecalendar.library.interactors.AUCalendar;
import com.molo17.customizablecalendar.library.model.Calendar;
import com.thecatalyst.catalyst.Adapter.CalendarViewInteractor;
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Service.GetData;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;


public class TaskDetailsActivity extends AppCompatActivity {
    AlertDialog builder;
    @BindView(R.id.view_month)
    CustomizableCalendar customizableCalendar;
    final com.molo17.customizablecalendar.library.model.Calendar calendar = null;
    public boolean multipleSelection=false;
    private CompositeDisposable subscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
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

        Intent intent = getIntent();

        String name = intent.getStringExtra("Name");
        String startdt = intent.getStringExtra("StartDate");
        String enddt = intent.getStringExtra("EndDate");
        String remdy = intent.getStringExtra("Rem");
        String details = intent.getStringExtra("Details");
        int index = intent.getIntExtra("Index", 0);
        String s1 = intent.getStringExtra("Members");
        String s2 = intent.getStringExtra("Technology");
        DateTime st = DateTime.parse(startdt);
        DateTime en = DateTime.parse(enddt);
        Log.e("TAG", "onCreateDATE: "+DateTime.parse(enddt) );
        Log.e("TAG", "onCreateS1MEMBERS: "+s1 );
        Log.e("TAG", "onCreateS2TECHNOLOGY: "+s2 );

        ButterKnife.bind(this);
        subscriptions = new CompositeDisposable();
        updateData(st,en);



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

            String[] s = s1 != null ? s1.split(",") : new String[0];
            String[] st1 = s2 != null ? s2.split(",") : new String[0];


                Log.e("TAG", "onResponseLength: "+ s.length);
                Log.e("TAG", "onResponseLength: "+st1.length);

                for (String s4 : s) {
                    tech.add(s4);
                    Log.e("TAG", "onResponseMem: " + s4);
                }

                for (String s3 : st1) {
                    tmember.add(s3);
                    Log.e("TAG", "onResponseTech: " + s3);
                }

                techSp.setAdapter(new ArrayAdapter<>(TaskDetailsActivity.this, android.R.layout.simple_spinner_dropdown_item, tech));
                memberSp.setAdapter(new ArrayAdapter<>(TaskDetailsActivity.this, android.R.layout.simple_spinner_dropdown_item, tmember));


        techSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String techname = techSp.getItemAtPosition(techSp.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(), techname, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        memberSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String membername = memberSp.getItemAtPosition(memberSp.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(), membername, Toast.LENGTH_SHORT).show();
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

    }

    private void updateData(DateTime st, DateTime en) {

        DateTime firstMonth = st.withDayOfMonth(1);
        DateTime lastMonth = en.plusMonths(3).withDayOfMonth(1);
        Log.e("TAG", "updateData: "+firstMonth );

        final com.molo17.customizablecalendar.library.model.Calendar calendar = new Calendar(firstMonth, lastMonth);


            calendar.setFirstSelectedDay(st.minusDays(1));
               calendar.setLastSelectedDay(en);
        calendar.setMultipleSelection(true);

        final CalendarViewInteractor calendarViewInteractor = new CalendarViewInteractor(getBaseContext());
        AUCalendar auCalendar = AUCalendar.getInstance(calendar);
        calendarViewInteractor.updateCalendar(calendar);
        subscriptions.add(
                auCalendar.observeChangesOnCalendar()
                .subscribe()
        );

        customizableCalendar.injectViewInteractor(calendarViewInteractor);

    }

}
