package com.thecatalyst.catalyst.Adapter;
<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

=======

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thecatalyst.catalyst.Activity.TaskDetailsActivity;
<<<<<<< HEAD
=======
import com.thecatalyst.catalyst.Model.Datum;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Model.RetroUsers;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder>{
<<<<<<< HEAD
    private List<RetroUsers> dataList;
    private boolean fabstate = false;

    private Date CurrentDate = Calendar.getInstance().getTime();
    private String dateFormat = CurrentDate.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate date1 = org.joda.time.LocalDate.parse(dateFormat,format);

    Context context;
    public MyAdapter(List<RetroUsers> dataList, Context context){
=======
    private List<Datum> dataList;
//    private List<Technology> technologyList;
    private Date cd = Calendar.getInstance().getTime();
    private String dateFormat = cd.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate datel = org.joda.time.LocalDate.parse(dateFormat, format);


    //    private boolean fabstate = false;
    private Context context;

    public MyAdapter(List<Datum> dataList,Context context){
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        this.dataList = dataList;
        this.context=context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

<<<<<<< HEAD
        public final View myView;
=======
        final View myView;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        TextView textUser;
        TextView textDetails;
        TextView startDate;
        TextView endDate;
<<<<<<< HEAD
        TextView remaining_days;
        CardView cardView;
        RecyclerView recycler_child;
        LinearLayout colorView;
        ImageView arrow_btn;
=======
        CardView cardView;
        RecyclerView recycler_child;
        ImageView arrow;
        LinearLayout colorView;
        LinearLayout belproj;
        LinearLayout belowdate;
        TextView remainindDays;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
<<<<<<< HEAD
            textUser = myView.findViewById(R.id.userc);
            textDetails = myView.findViewById(R.id.detailsc);
            startDate = myView.findViewById(R.id.start_date);
            endDate = myView.findViewById(R.id.end_date);
            cardView = myView.findViewById(R.id.card);
            recycler_child = myView.findViewById(R.id.recycler_child);
            colorView = myView.findViewById(R.id.col);
            arrow_btn=myView.findViewById(R.id.arrow_btn);
            remaining_days=myView.findViewById(R.id.remaining_days);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
=======
            textUser = myView.findViewById(R.id.user);
            textDetails = myView.findViewById(R.id.details);
            startDate = myView.findViewById(R.id.start_Date);
            endDate = myView.findViewById(R.id.end_Date);
            arrow = myView.findViewById(R.id.arrow_img);
            cardView = myView.findViewById(R.id.card);
            remainindDays = myView.findViewById(R.id.remaing_Days);
            recycler_child = myView.findViewById(R.id.recycler_child);
            colorView = myView.findViewById(R.id.col);
            belproj = myView.findViewById(R.id.laybelowmainproject);
            belowdate = myView.findViewById(R.id.laymaindate);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
<<<<<<< HEAD
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getName());
        holder.textDetails.setText(dataList.get(position).getDetails());
        holder.startDate.setText(dataList.get(position).getStartDate());
        holder.endDate.setText(dataList.get(position).getEndDate());
        Log.e("TAG", "onBindCurrentDate: "+CurrentDate );
=======
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {

        holder.textUser.setText(dataList.get(position).getName());
        holder.textDetails.setText(dataList.get(position).getDetails());
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

        String string = dataList.get(position).getEndDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDate date = org.joda.time.LocalDate.parse(string, formatter);
<<<<<<< HEAD
        Log.e("TAG", "onBindCurrentDate: "+date1 );
        holder.remaining_days.setText(String.format("%s days", Days.daysBetween(date1, date).getDays()));

        holder.arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TaskDetailsActivity.class);
                intent.putExtra("Name",dataList.get(position).getName());
                intent.putExtra("StartDate",dataList.get(position).getStartDate());
                intent.putExtra("EndDate",dataList.get(position).getEndDate());
                intent.putExtra("Details",dataList.get(position).getDetails());
                context.startActivity(intent);
            }
        });
//

        Log.e("TAG", "DATA LIST ADAPTER: "+dataList.toString() );

        MyAdapter2 adapter = new MyAdapter2(dataList.get(position).getTask(),context);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recycler_child.setLayoutManager(layoutManager);
        holder.recycler_child.setAdapter(adapter);
//        Random rnd = new Random();
//        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.colorView.setBackgroundColor(Color.parseColor("#ffffff"));
        adapter.notifyDataSetChanged();
        holder.recycler_child.setVisibility(View.GONE);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.recycler_child.setVisibility(View.VISIBLE);
            }
        });
    }

=======
        Log.e("TAG", "onBindViewHolder: "+ date );
        Log.e("TAG", "onBindViewdate: " + dateFormat);
//        Log.e("TAG", "onBindViewget: "+ getDateFormat );
        Log.e("TAG", "onBindViewlocal: "+ datel );
        holder.remainindDays.setText(MessageFormat.format("{0} days", Days.daysBetween(datel, date).getDays()));
//        holder.remainindDays.setText(getCountOfDays( dataList.get(position).getStartDate(), dataList.get(position).getEndDate()));

//        if (technologyList.get(position).getProjectId().equals(dataList.get(position).getId())) {

            holder.startDate.setText(dataList.get(position).getStartDate());
            holder.endDate.setText(dataList.get(position).getEndDate());
//          c =  holder.startDate.getText() - holder.endDate.getText();
//        }

        Log.e("TAG", "DATA LIST ADAPTER: "+dataList.toString() );

//        MyAdapter2 adapter = new MyAdapter2(data.get(position).getTask(),context);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recycler_child.setLayoutManager(layoutManager);
//        holder.recycler_child.setAdapter(adapter);
        holder.arrow.setOnClickListener(v -> {
                    Intent intent = new Intent(context,TaskDetailsActivity.class);
            intent.putExtra("Name",dataList.get(position).getName());
            intent.putExtra("StartDate",dataList.get(position).getStartDate());
            intent.putExtra("EndDate",dataList.get(position).getEndDate());
            intent.putExtra("Rem",MessageFormat.format("{0}days",Days.daysBetween(datel,date).getDays()));
            intent.putExtra("Details",dataList.get(position).getDetails());
            intent.putExtra("Index", position);
            context.startActivity(intent);
                }
        );
/*
Random rnd = new Random();
int currentColor = Color.argb(, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
holder.colorView.setBackgroundColor(Color.parseColor("#000000"));
*/

//
//        adapter.notifyDataSetChanged();
//        holder.recycler_child.setVisibility(View.GONE);
//
//        holder.cardView.setOnClickListener(v -> holder.recycler_child.setVisibility(View.VISIBLE));
    }


>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: " + dataList.size() );
        return dataList.size();
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
