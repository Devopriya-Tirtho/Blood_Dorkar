package com.example.shafin.blood_dorkar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchOrDonor extends AppCompatActivity {

    private Button searchdonor,bedonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_or_donor);

        searchdonor=(Button) findViewById(R.id.searchdonor);
        bedonor=(Button) findViewById(R.id.bedonor);

        searchdonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchordonor_to_search=new Intent(SearchOrDonor.this,SearchActivity.class);
                startActivity(searchordonor_to_search);

            }
        });



        bedonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchordonor_to_donor=new Intent(SearchOrDonor.this,DonorRegistrationActivity.class);
                startActivity(searchordonor_to_donor);

            }
        });

    }
    @Override
    public void onBackPressed(){
        Intent searchordonor_to_home=new Intent(SearchOrDonor.this,HomeActivity.class);
        startActivity(searchordonor_to_home);
        finish();
    }
}
