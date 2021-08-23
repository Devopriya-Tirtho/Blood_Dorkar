package com.example.shafin.blood_dorkar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DatabaseHandler;
import Model.Donor;

public class DonorRegistrationActivity extends AppCompatActivity {

    private Button submit;
    private EditText name,age,address,number,bloodgroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registration);

        Button submit = (Button) findViewById(R.id.submit);
        name=(EditText) findViewById(R.id.fullname);
        bloodgroup=(EditText) findViewById(R.id.bloodgroup) ;
        age=(EditText) findViewById(R.id.age) ;
        address=(EditText)findViewById(R.id.address) ;
        number=(EditText) findViewById(R.id.number) ;
        final DatabaseHandler db=new DatabaseHandler(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name=name.getText().toString();
                String _bloodgroup=bloodgroup.getText().toString();
                String _age=age.getText().toString();
                String _address=address.getText().toString();
                String _number=number.getText().toString();


                if(_name.equals("") || _bloodgroup.equals("") || _age.equals("") || _address.equals("") || _number.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addDonor(new Donor(_name,_bloodgroup,_age,_address,_number));
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();
                }
                Intent donor_to_searchordonor=new Intent(DonorRegistrationActivity.this,SearchOrDonor.class);
                startActivity(donor_to_searchordonor);




            }
        });


    }
}
