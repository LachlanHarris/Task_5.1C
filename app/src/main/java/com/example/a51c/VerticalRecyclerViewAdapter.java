package com.example.a51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder> {

    private List<Places> PlacesList;
    private Context context;
    private OnRowClickListener listener;

    public VerticalRecyclerViewAdapter(List<Places> PlacesList, Context context, OnRowClickListener listener) {
        this.PlacesList = PlacesList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VerticalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.places_row, parent, false);

        return new ViewHolder(itemView, listener);

    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.placesTitle.setText(PlacesList.get(position).getTitle());
        holder.placesDescription.setText(PlacesList.get(position).getDescription());
        holder.placeImage.setImageResource(PlacesList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return PlacesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView placeImage;
        TextView placesTitle;
        TextView placesDescription;

        public OnRowClickListener onRowClickListener;

        public ViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.placeImage);
            placesTitle = itemView.findViewById(R.id.placeTitle);
            placesDescription = itemView.findViewById(R.id.placeDescription);

            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
