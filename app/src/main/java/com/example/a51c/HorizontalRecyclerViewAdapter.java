package com.example.a51c;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private List<TopDestinations> destinationsList;
    private Context context;

    public HorizontalRecyclerViewAdapter(List<TopDestinations> destinationsList, Context context)
    {
        this.destinationsList = destinationsList;
        this.context = context;
    }

    @NonNull
    @Override
    public HorizontalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.topdestination_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.destinationsTitle.setText(destinationsList.get(position).getTitle());
        holder.destinationImage.setImageResource(destinationsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return destinationsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView destinationsTitle;
        ImageView destinationImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationsTitle = itemView.findViewById(R.id.destinationTitle);
            destinationImage = itemView.findViewById(R.id.destinationImage);
        }

    }
}
