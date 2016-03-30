package com.thefourstars.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thefourstars.myapp.R;

/**
 * Created by Duggu on 21-Nov-15.
 */
public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textdetails;
    private TextView textheading;
    private Button  button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        String heading = getIntent().getStringExtra("heading");
        textdetails= (TextView) findViewById(R.id.textdetails);
        textheading= (TextView) findViewById(R.id.textheading);
        textheading.setText(heading);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        if(heading.equals("Techno Buzz")){
        textdetails.setText(getResources().getString(R.string.Techno_buzz));
        }else if(heading.equals("C Mania")){
            textdetails.setText(getResources().getString(R.string.C_mania));
        }else if(heading.equals("Robo Race")){
            textdetails.setText(getResources().getString(R.string.Robo_race));
        }else if(heading.equals("Codec")){
            textdetails.setText(getResources().getString(R.string.Codec));
        }else if(heading.equals("Lan Gaming")){
            textdetails.setText(getResources().getString(R.string.Lan_gaming));
        }else if(heading.equals("Football")){
            textdetails.setText(getResources().getString(R.string.Football));
        }else if(heading.equals("Basket Ball")){
            textdetails.setText(getResources().getString(R.string.Basketball));
        }else if(heading.equals("Cricket")){
            textdetails.setText(getResources().getString(R.string.Cricket));
        }else if(heading.equals("D Virus")){
            textdetails.setText(getResources().getString(R.string.D_virus));
        }else if(heading.equals("Viral Voice")){
            textdetails.setText(getResources().getString(R.string.Viral_voice));
        }else if(heading.equals("Conference NCETCE")){
            textdetails.setText(getResources().getString(R.string.NCETCE));
        }else if(heading.equals("Workshop on Infosys Campus Connect")){
            textdetails.setText(getResources().getString(R.string.info));
        }else if(heading.equals("Workshop On IBM Bluemix")){
            textdetails.setText(getResources().getString(R.string.IBM));
        }



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), StudentRegisterActivity.class);
        startActivity(intent);

    }
}
