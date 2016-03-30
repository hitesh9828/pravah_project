package com.thefourstars.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.thefourstars.myapp.R;
import com.thefourstars.myapp.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ExpandableListView.OnChildClickListener {
    private ViewFlipper viewFlipper;
    private ExpandableListView expandableListView;
    private ArrayList<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void initialize(){
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlliper);
        viewFlipper.startFlipping();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        setListViewData();
        expandableListView.setAdapter(new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild));
        expandableListView.setOnChildClickListener(this);
    }
    public void setListViewData(){
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        String headerTitles[] = getResources().getStringArray(R.array.headers);

        for(String title:headerTitles){
            listDataHeader.add(title);
        }

        for(int i = 0;i<listDataHeader.size();i++){
            String []childs = null;
            if(i==0)
                childs = getResources().getStringArray(R.array.technical_child);
            else if(i==1)
                childs = getResources().getStringArray(R.array.non_technical_child);
            else if(i==2)
                childs = getResources().getStringArray(R.array.academic_child);
            List<String> childList = new ArrayList<String>();
            for(String child : childs){
                childList.add(child);
            }
            if(childList.size()>0)
                listDataChild.put(listDataHeader.get(i), childList); // Header, Child data
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activities in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.byCollegeName) {
            Intent intent = new Intent(getApplicationContext(), CollegeNameActivity.class);
            startActivity(intent);
        }else if(id == R.id.byEventName){
            Toast.makeText(getApplicationContext(),"event name",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }  

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        String child = (String) expandableListView.getExpandableListAdapter().getChild(groupPosition,childPosition);
        Intent intent = new Intent(getApplicationContext(),EventDetailsActivity.class);
        intent.putExtra("heading",child);
        startActivity(intent);




        return false;
    }
}
