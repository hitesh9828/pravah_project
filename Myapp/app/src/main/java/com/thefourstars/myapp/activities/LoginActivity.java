package com.thefourstars.myapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thefourstars.myapp.R;
import com.thefourstars.myapp.controlers.Constants;
import com.thefourstars.myapp.databases.DatabaseHandler;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView sign_up;
    private EditText etUsername, etPassword;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        sign_up = (TextView) findViewById(R.id.sign_up);
        sign_up.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.login_button);
        btnLogin.setOnClickListener(this);
        etUsername = (EditText) findViewById(R.id.editText_email);
        etPassword = (EditText) findViewById(R.id.editText2_password);

    }

    @Override
    public void onClick(View v) {
        if (R.id.sign_up == v.getId()) {
            Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(intent);

        } else if (R.id.login_button == v.getId()) {
            String email = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            checkData(email,password);
        }
    }
    private void checkData(String userName, String passWord) {
       String [] data = new DatabaseHandler(getApplicationContext()).getLoginDetails(userName);
        if(data != null){
            if(data.length >0){
                if(data[0].equals(userName) && data[1].equals(passWord)){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }
        }
    }
}