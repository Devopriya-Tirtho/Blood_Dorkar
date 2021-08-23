package com.example.shafin.blood_dorkar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DatabaseHandler;
import Model.Contact;

public class HomeActivity extends AppCompatActivity {

    private Button signUp_,signIn_;
    private EditText userName_,userPassword_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        signUp_=(Button) findViewById(R.id.sign_up);
        signIn_=(Button) findViewById(R.id.sign_in);
        userName_=(EditText) findViewById(R.id.user_name) ;
        userPassword_=(EditText) findViewById(R.id.user_password) ;

        final DatabaseHandler db=new DatabaseHandler(this);



        signIn_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String signInUserName=userName_.getText().toString();
                String signInUserPassword=userPassword_.getText().toString();

                if(signInUserName.equals("")|| signInUserPassword.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else {

                    Boolean result=db.loginCheck(signInUserName,signInUserPassword);
                    if(result==true)
                    {
                        Toast.makeText (getApplicationContext(),"log in successfully.",Toast.LENGTH_SHORT).show();
                        Intent home_to_searchordonor=new Intent(HomeActivity.this,SearchOrDonor.class);
                        startActivity(home_to_searchordonor);
                    }
                    else
                        Toast.makeText (getApplicationContext(),"username & password didn't match.",Toast.LENGTH_SHORT).show();

                }
            }
        });

        signUp_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home_to_signup=new Intent(HomeActivity.this,SignUpActivity.class);
                startActivity(home_to_signup);

            }
        });


    }
    @Override
    public void onBackPressed(){
        onStop();
        finish();
    }

}

