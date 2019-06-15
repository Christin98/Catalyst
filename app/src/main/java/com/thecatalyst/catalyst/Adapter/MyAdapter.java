package com.thecatalyst.catalyst.Adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
    private List<RetroUsers> dataList;
    private boolean fabstate = false;

    private Date CurrentDate = Calendar.getInstance().getTime();
    private String dateFormat = CurrentDate.toString();
    private DateTimeFormatter format = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zx:x yyyy");
    private LocalDate date1 = org.joda.time.LocalDate.parse(dateFormat,format);

    Context context;
    public MyAdapter(List<RetroUsers> dataList, Context context){
        this.dataList = dataList;
        this.context=context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View myView;
        TextView textUser;
        TextView textDetails;
        TextView startDate;
        TextView endDate;
        TextView remaining_days;
        CardView cardView;
        RecyclerView recycler_child;
        LinearLayout colorView;
        ImageView arrow_btn;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getName());
        holder.textDetails.setText(dataList.get(position).getDetails());
        holder.startDate.setText(dataList.get(position).getStartDate());
        holder.endDate.setText(dataList.get(position).getEndDate());
        Log.e("TAG", "onBindCurrentDate: "+CurrentDate );

        String string = dataList.get(position).getEndDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDate date = org.joda.time.LocalDate.parse(string, formatter);
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

    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: " + dataList.size() );
        return dataList.size();
    }

}