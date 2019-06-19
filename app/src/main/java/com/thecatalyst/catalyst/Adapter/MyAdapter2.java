package com.thecatalyst.catalyst.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thecatalyst.catalyst.Activity.TaskDetailsActivity;
import com.thecatalyst.catalyst.Model.Child;
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
    private List<Child> dataList;
//    private boolean fabstate = false;

    private Date cd = Calendar.getInstance().getTime();
    private String dateFormat = cd.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate datel = org.joda.time.LocalDate.parse(dateFormat, format);

    private Context context;

    MyAdapter2(List<Child> dataList , Context context){
        this.dataList = dataList;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        final View myView;
        TextView textUser;
        TextView textDetails;
        TextView textStartDate;
        TextView textEndDate;
        ImageView arrow_img_child;
        CardView card_child;
        RecyclerView recycler_child1;
        TextView textRemainingDays;


        MyViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.userc);
            textDetails = myView.findViewById(R.id.detailsc);
            textStartDate = myView.findViewById(R.id.start_Datec);
            textEndDate = myView.findViewById(R.id.end_Datec);
            arrow_img_child = myView.findViewById(R.id.arrow_imgc);
            card_child = myView.findViewById(R.id.cardc);
            recycler_child1 = myView.findViewById(R.id.recycler_child1);
            textRemainingDays = myView.findViewById(R.id.remaing_Daysc);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_child, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Log.e("TAG", "onBindViewHolder: "+dataList.get(position).toString() );
        holder.textUser.setText(dataList.get(position).getName());
        holder.textDetails.setText(dataList.get(position).getDetails());

        String string = dataList.get(position).getEndDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDate date = org.joda.time.LocalDate.parse(string, formatter);
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
        MyAdapter2 adapter = new MyAdapter2(dataList.get(position).getChildren(),context);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recycler_child1.setLayoutManager(layoutManager);
        holder.recycler_child1.setAdapter(adapter);

        holder.arrow_img_child.setOnClickListener(v -> {
                    Intent intent = new Intent(context, TaskDetailsActivity.class);
                    intent.putExtra("Name",dataList.get(position).getName());
                    intent.putExtra("StartDate",dataList.get(position).getStartDate());
                    intent.putExtra("EndDate",dataList.get(position).getEndDate());
                    intent.putExtra("Rem",MessageFormat.format("{0}days",Days.daysBetween(datel,date).getDays()));
                    intent.putExtra("Details",dataList.get(position).getDetails());
                    intent.putExtra("Id",dataList.get(position).getId());
                    intent.putExtra("Members",dataList.get(position).getAllTeamMembers());
                    intent.putExtra("Technology",dataList.get(position).getAllTechnology());
                    context.startActivity(intent);
                }
        );
        adapter.notifyDataSetChanged();
        holder.recycler_child1.setVisibility(View.GONE);

        holder.card_child.setOnClickListener(v -> holder.recycler_child1.setVisibility(View.VISIBLE));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
