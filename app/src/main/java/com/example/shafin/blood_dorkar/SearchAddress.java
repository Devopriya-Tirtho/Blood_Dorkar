package com.example.shafin.blood_dorkar;

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

public class SearchAddress extends AppCompatActivity {


    private Button addresssearch;
    private TextView displayAdd;
    private EditText searchAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);


        final DatabaseHandler db=new DatabaseHandler(this);



        addresssearch=(Button)findViewById(R.id.Search_add) ;
        searchAdd=(EditText) findViewById(R.id.S_Add) ;
        displayAdd=(TextView) findViewById(R.id.display_add) ;
        displayAdd.setMovementMethod(new ScrollingMovementMethod());



        addresssearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address_name=searchAdd.getText().toString();

                List<Donor> myContactList=db.getAllAddress(address_name);
                String result = "";
                for(Donor myContact : myContactList)
                {
                    result +="Name: "+myContact.get_name()+"\n"+"Blood Group :"+myContact.get_bloodgroup()+"\n"+"Phone :"+myContact.get_phoneNumber()+"\n"+"Address :"+myContact.get_address();
                    result +="\n\n";

                }
                if(myContactList.size()  == 0)
                {
                    result = "No contact to display.";
                }
                displayAdd.setText(result);

            }
        });


    }
}