package com.thefourstars.myapp.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.thefourstars.myapp.R;
import com.thefourstars.myapp.controlers.Constants;
import com.thefourstars.myapp.databases.DatabaseHandler;

/**
 * Created by Duggu on 01-Nov-15.
 */
public class RegistrationActivity extends Activity implements View.OnClickListener {
    private EditText name, email, collegename, username, password;
    private Button submit_signup;
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        collegename= (EditText) findViewById(R.id.college_name);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.Password);
        submit_signup= (Button) findViewById(R.id.submit_signup);
        male= (RadioButton) findViewById(R.id.male);
        female= (RadioButton) findViewById(R.id.female);
        submit_signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        String str_collegename = collegename.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String sex;
        if (male.isChecked()) {
            sex = "male";
        }
        else {
            sex = "female";
        }
        if (str_name.equals(""))
            name.setError("Field Required");
        else if (str_username.equals(""))
            username.setError("Field Required");
        else if (str_password.equals(""))
            password.setError("Field Required");
        else if (str_collegename.equals(""))
            collegename.setError("Field Required");
        else if (str_email.equals(""))
            email.setError("Field Required");
        else{
            long result = new DatabaseHandler(getApplicationContext()).insertDetails(str_name,str_username,str_password,str_email,str_collegename,sex);
            if(result>0) {
                Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_LONG).show();
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "User already exist", Toast.LENGTH_LONG).show();
            }
        }
    }
}

