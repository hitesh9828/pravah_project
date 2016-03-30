package com.thefourstars.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.thefourstars.myapp.R;

/**
 * Created by Duggu on 20-Nov-15.
 */
public class CollegeNameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView collegelv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegename_activity);
        collegelv = (ListView) findViewById(R.id.collegeListview);
        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.College_names));
        collegelv.setAdapter(adapter);
        collegelv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        finish();
    }
}
