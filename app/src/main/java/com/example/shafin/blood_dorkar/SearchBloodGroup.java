package com.example.shafin.blood_dorkar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import Database.DatabaseHandler;
import Model.Donor;

public class SearchBloodGroup extends AppCompatActivity {

    private Button bloodgroupsearch;
    private TextView display;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood_group);
        final DatabaseHandler db=new DatabaseHandler(this);



        bloodgroupsearch=(Button)findViewById(R.id.Search) ;
        searchText=(EditText) findViewById(R.id.S_bloodgrp) ;
        display=(TextView) findViewById(R.id.display) ;
        display.setMovementMethod(new ScrollingMovementMethod());



        bloodgroupsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String blood_group_name=searchText.getText().toString();

                List<Donor> myContactList=db.getAllContact(blood_group_name);
                String result = "";
                for(Donor myContact : myContactList)
                {
                    result +="Name: "+myContact.get_name()+"\n"+"Blood Group :"+myContact.get_bloodgroup()+"\n"+"Phone :"+myContact.get_phoneNumber();
                    result +="\n\n";

                }
                if(myContactList.size()  == 0)
                {
                    result = "No contact to display.";
                }
                display.setText(result);

            }
        });

    }
}
