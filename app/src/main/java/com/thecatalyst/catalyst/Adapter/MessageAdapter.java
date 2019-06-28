package com.thecatalyst.catalyst.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thecatalyst.catalyst.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    public MessageAdapter(Context context){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewMessage;
        public TextView textViewName;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.message_body);
            textViewName = itemView.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_message, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.textViewMessage.setText("ITS A Long Message for Testing The Interface" );
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
