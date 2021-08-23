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

public class SignUpActivity extends AppCompatActivity {

    private Button sign_up_button;
    private EditText sign_up_name,sign_up_password,sign_up_phn,sign_up_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        sign_up_button = (Button) findViewById(R.id.submit_button);
        sign_up_name = (EditText) findViewById(R.id.sign_up_name);
        sign_up_password = (EditText) findViewById(R.id.sign_up_password);
        sign_up_email = (EditText) findViewById(R.id.sign_up_email);
        sign_up_phn = (EditText) findViewById(R.id.sign_up_phn);


        final DatabaseHandler db=new DatabaseHandler(this);

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userNameValue= sign_up_name.getText().toString();
                String userPasswordValue= sign_up_password.getText().toString();
                String userEmailValue= sign_up_email.getText().toString();
                String phoneValue= sign_up_phn.getText().toString();

                if(userNameValue.equals("") || userPasswordValue.equals("") || userEmailValue.equals("") || phoneValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addContact(new Contact(userNameValue,userPasswordValue,userEmailValue,phoneValue));
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();
                }

                Intent signup_to_home=new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(signup_to_home);


            }
        });
    }


}
