//Steven Cruickshank
//Project 3 - Inventory App

package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    private ArrayList<whInventory> invArrayList;
    private Context context;

    // constructor
    public RVAdapter(ArrayList<whInventory> courseModalArrayList, Context context) {
        this.invArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //setting the approriate textfields
        whInventory modal = invArrayList.get(position);
        holder.itemNameTV.setText(modal.getItemName());
        holder.itemDescTV.setText(modal.getItemDesc());
        holder.itemStock.setText(modal.getItemStock());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return invArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for text views.
        private TextView itemNameTV, itemDescTV, itemStock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing text views
            itemNameTV = itemView.findViewById(R.id.idItemName);
            itemDescTV = itemView.findViewById(R.id.idItemDesc);
            itemStock = itemView.findViewById(R.id.itemStock);
        }
    }}
