package com.thecatalyst.catalyst.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thecatalyst.catalyst.Activity.ChatActivity;
import com.thecatalyst.catalyst.Model.Child;
import com.thecatalyst.catalyst.R;

import java.util.List;

public class ChatChildAdapter extends RecyclerView.Adapter<ChatChildAdapter.ViewHolder> {

    private List<Child> dataList;
    private Context context;

    public ChatChildAdapter(List<Child> dataList,Context context){
        this.dataList = dataList;
        this.context=context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View myView;
        TextView textUser;
        TextView textDetails;
        RecyclerView recycler_child;
        RelativeLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.dot);
            textDetails = myView.findViewById(R.id.project_name);
            recycler_child = myView.findViewById(R.id.recycler_child_chat);
            relativeLayout = myView.findViewById(R.id.relative_chat);
        }
    }

    @NonNull
    @Override
    public ChatChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_main, parent, false);
        return new ChatChildAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatChildAdapter.ViewHolder holder, int position) {
        holder.textUser.setText(Html.fromHtml("&#8226;"));
        holder.textDetails.setText(dataList.get(position).getName());
        holder.relativeLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChatActivity.class);
            context.startActivity(intent);
        });

        ChatChildAdapter adapter = new ChatChildAdapter(dataList.get(position).getChildren(),context);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recycler_child.setLayoutManager(layoutManager);
        holder.recycler_child.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
