package com.example.shafin.blood_dorkar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    private Button Search_bloodGroup,Search_Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Search_bloodGroup=(Button) findViewById(R.id.Search_blood_group);
        Search_Add=(Button) findViewById(R.id.Search_address);

        Search_bloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent search_to_searchBloodGrp=new Intent(SearchActivity.this,SearchBloodGroup.class);
                startActivity(search_to_searchBloodGrp);

            }
        });


        Search_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent search_to_searchAddress=new Intent(SearchActivity.this,SearchAddress.class);
                startActivity(search_to_searchAddress);

            }
        });

    }
}
