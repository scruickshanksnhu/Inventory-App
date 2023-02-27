//Steven Cruickshank
//Project 3 - Inventory App

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);

        //setting the text view to be a different color
        TextView t = (TextView)findViewById(R.id.textView);
        t.setTextColor(this.getResources().getColor(R.color.purple_700));

        //initializing edit texts and buttons
        EditText et1 = (EditText)findViewById(R.id.editTextUsername);
        EditText et2 = (EditText)findViewById(R.id.editTextPassword);
        Button b1 = (Button)findViewById(R.id.buttonLogIn);


        // creating a new dbhandler class
        // and passing our context to it.
        loginDB handler = new loginDB(MainActivity.this);
        warehouseDB handler2 = new warehouseDB(MainActivity.this);

        // adding a click listener for the login button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Extract data from edittexts
                String userName = et1.getText().toString();
                String pw = et2.getText().toString();


                // checking if fields are empty or not
                if (userName.isEmpty() && pw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                //using the handlers to add new login info and a new item (for testing purposes)
                handler.addLoginInfo(userName, pw);
                handler2.addNewItem("Test Item", "Test Description", 4);

                //after logging in, this intent will call the recycler view
                Intent i = new Intent(MainActivity.this, ViewItems.class);
                startActivity(i);



                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Login info has been added.", Toast.LENGTH_SHORT).show();
            }
        });




    }

}

