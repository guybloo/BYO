package com.example.byo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.byo.Types.Byo;

import java.util.ArrayList;


public class ByoAdapter extends RecyclerView.Adapter<ByoAdapter.ItemsEditViewHolder> {
    private ArrayList<Byo> itemsList;
    private ByoAdapter.OnItemClickListener myListener;
    private boolean isGroup;

    public interface OnItemClickListener {
        void onItemIncrease(int position);

        void onItemDecrease(int position);
    }

    public void setOnItemClickListener(ByoAdapter.OnItemClickListener listener) {
        myListener = listener;
    }

    public static class ItemsEditViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView amount;
        public TextView increase;
        public TextView decrease;
        public ProgressBar progressBar;

        public ItemsEditViewHolder(@NonNull View itemView, final ByoAdapter.OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            amount = itemView.findViewById(R.id.item_amount);
            increase = itemView.findViewById(R.id.increase);
            decrease = itemView.findViewById(R.id.decrease);
            progressBar = itemView.findViewById(R.id.progress);

            increase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemIncrease(position);
                        }
                    }
                }
            });

            decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemDecrease(position);
                        }
                    }
                }
            });
        }
    }

    public ByoAdapter(ArrayList<Byo> list, boolean isGroup) {
        itemsList = list;
        this.isGroup = isGroup;
    }

    @NonNull
    @Override
    public ItemsEditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_edit, parent,
                false);
        ItemsEditViewHolder evh = new ItemsEditViewHolder(v, myListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsEditViewHolder holder, int position) {
        ItemCount currentItem = itemsList.get(position);
        holder.title.setText(currentItem.getName());
        holder.progressBar.setProgress((int)(currentItem.getPrecentage() * holder.progressBar.getMax()));
        holder.amount.setText(String.valueOf(currentItem.getAmount()));
        if(isGroup){
            holder.increase.setVisibility(View.INVISIBLE);
            holder.decrease.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

}