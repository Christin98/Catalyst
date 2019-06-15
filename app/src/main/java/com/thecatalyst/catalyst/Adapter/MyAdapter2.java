package com.thecatalyst.catalyst.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

<<<<<<< HEAD
import androidx.fragment.app.FragmentManager;
=======
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

<<<<<<< HEAD
import com.thecatalyst.catalyst.Activity.LoginActivity;
import com.thecatalyst.catalyst.Activity.TaskDetailsActivity;
import com.thecatalyst.catalyst.Activity.TaskScreenActivity;
=======
import com.thecatalyst.catalyst.Activity.TaskDetailsActivity;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import com.thecatalyst.catalyst.R;
import com.thecatalyst.catalyst.Model.Task;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private List<Task> dataList;
<<<<<<< HEAD

    private Date CurrentDate = Calendar.getInstance().getTime();
    private String dateFormat = CurrentDate.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate date1 = org.joda.time.LocalDate.parse(dateFormat,format);

//    private boolean fabstate = false;
Context context;

    public MyAdapter2(List<Task> dataList, Context context){
=======
//    private boolean fabstate = false;

    private Date cd = Calendar.getInstance().getTime();
    private String dateFormat = cd.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate datel = org.joda.time.LocalDate.parse(dateFormat, format);

    private Context context;

    MyAdapter2(List<Task> dataList , Context context){
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        this.dataList = dataList;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

<<<<<<< HEAD
        public final View myView;
        TextView textUser;
        TextView textDetails;
        TextView startDate;
        TextView endDate;
        LinearLayout colorbg2;
        ImageView arrow_btn;
        TextView remaining_days;
=======
        final View myView;
        TextView textUser;
        TextView textDetails;
        TextView textStartDate;
        TextView textEndDate;
        ImageView arrow_img_child;
        CardView card_child;
        TextView textRemainingDays;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3


        MyViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.userc);
            textDetails = myView.findViewById(R.id.detailsc);
<<<<<<< HEAD
            startDate = myView.findViewById(R.id.start_date);
            endDate = myView.findViewById(R.id.end_date);
            arrow_btn=myView.findViewById(R.id.arrow_btn);
            remaining_days=myView.findViewById(R.id.remaining_days);
=======
            textStartDate = myView.findViewById(R.id.start_Datec);
            textEndDate = myView.findViewById(R.id.end_Datec);
            arrow_img_child = myView.findViewById(R.id.arrow_imgc);
            card_child = myView.findViewById(R.id.cardc);
            textRemainingDays = myView.findViewById(R.id.remaing_Daysc);
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

        }
    }

<<<<<<< HEAD
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
=======
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_child, parent, false);
        return new MyViewHolder(view);
    }

    @Override
<<<<<<< HEAD
    public void onBindViewHolder(final MyViewHolder holder, int position) {
=======
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

        Log.e("TAG", "onBindViewHolder: "+dataList.get(position).toString() );
        holder.textUser.setText(dataList.get(position).getName());
        holder.textDetails.setText(dataList.get(position).getDetails());
<<<<<<< HEAD
        holder.startDate.setText(dataList.get(position).getStartDate());
        holder.endDate.setText(dataList.get(position).getEndDate());
        Log.e("TAG", "onBindCurrentDate: "+CurrentDate );
=======
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
//        Random rnd = new Random();
//        int currentColor = Color.argb(252, rnd.nextInt(253), rnd.nextInt(253), rnd.nextInt(253));
//        holder.colorbg2.setBackgroundColor(currentColor);
=======
        Log.e("TAG", "onBindViewHolder: "+ date );
        Log.e("TAG", "onBindViewdate: " + dateFormat);
//        Log.e("TAG", "onBindViewget: "+ getDateFormat );
        Log.e("TAG", "onBindViewlocal: "+ datel );
        holder.textRemainingDays.setText(MessageFormat.format("{0}days", Days.daysBetween(datel, date).getDays()));
//        holder.remainindDays.setText(getCountOfDays( dataList.get(position).getStartDate(), dataList.get(position).getEndDate()));

//        if (technologyList.get(position).getProjectId().equals(dataList.get(position).getId())) {

        holder.textStartDate.setText(dataList.get(position).getStartDate());
        holder.textEndDate.setText(dataList.get(position).getEndDate());

        Log.e("TAG", "DATA LIST ADAPTER: "+dataList.toString() );

        holder.arrow_img_child.setOnClickListener(v -> {
                    Intent intent = new Intent(context, TaskDetailsActivity.class);
                    intent.putExtra("Name",dataList.get(position).getName());
                    intent.putExtra("StartDate",dataList.get(position).getStartDate());
                    intent.putExtra("EndDate",dataList.get(position).getEndDate());
                    intent.putExtra("Rem",MessageFormat.format("{0}days",Days.daysBetween(datel,date).getDays()));
                    intent.putExtra("Details",dataList.get(position).getDetails());
                    intent.putExtra("Id",dataList.get(position).getId());
                    context.startActivity(intent);
                }
        );

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
