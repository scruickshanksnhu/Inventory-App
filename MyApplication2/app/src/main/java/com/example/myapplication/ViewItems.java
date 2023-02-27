//Steven Cruickshank
//Project 3 - Inventory App
package com.example.myapplication;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewItems extends AppCompatActivity {

    // creating variables
    private ArrayList<whInventory> invArrayList;
    private warehouseDB dbHandler;
    private RVAdapter itemRVAdapter;
    private RecyclerView itemRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        // initializing variables.
        invArrayList = new ArrayList<>();
        dbHandler = new warehouseDB(ViewItems.this);

        // getting item list
        invArrayList = dbHandler.readCourses();

        // sending arraylist to the adapter class
        itemRVAdapter = new RVAdapter(invArrayList, ViewItems.this);
        itemRV = findViewById(R.id.idRVCourses);

        // setting layout manager for RV
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewItems.this, RecyclerView.VERTICAL, false);
        itemRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to RV.
        itemRV.setAdapter(itemRVAdapter);



    }
}