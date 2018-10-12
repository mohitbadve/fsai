package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mohit_pc.fsai.Feeds.CreateFeed;
import com.example.mohit_pc.fsai.Feeds.Feed;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirstFragment firstFragment = null;
    SecondFragment secondFragment = null;
    ThirdFragment thirdFragment = null;
    FourthFragment fourthFragment = null;
    Feed feed = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this,Alerts.class));
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //   .setAction("Action", null).show();
                Toast.makeText(MainActivity.this, "Chat", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent( MainActivity.this ,Chat.class);
                startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        swapFragment(new Feed());
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment swappable ;

        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        if (id == R.id.nav_first_layout) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame,new FirstFragment()).commit();
//        } else if (id == R.id.nav_second_layout) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame,new SecondFragment()).commit();
//        } else if (id == R.id.nav_third_layout) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame,new ThirdFragment()).commit();
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        switch (id){


            case  R.id.nav_first_layout:
                if(firstFragment == null){
                    firstFragment = new FirstFragment();
                }
                swapFragment(firstFragment);

                break;

            case  R.id.nav_second_layout:
                if(secondFragment == null){
                    secondFragment = new SecondFragment();

                }
                swapFragment(secondFragment);


                break;

            case R.id.nav_share:
                if(thirdFragment == null){
                    thirdFragment = new ThirdFragment();
                }
                swapFragment(thirdFragment);

                break;

            case R.id.nav_send:
                if(fourthFragment == null){
                    fourthFragment = new FourthFragment();
                }
                swapFragment(fourthFragment);

                break;
            case R.id.nav_feed:
                if(feed == null){
                    feed = new Feed();
                }
                swapFragment(feed);

                break;
            case R.id.nav_create_feed:
                swapFragment(new CreateFeed());
                break;
case R.id.nav_create_alert:
                swapFragment(new CreateNotification());
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    void swapFragment(Fragment frag){
        if(frag == null){
            Toast.makeText(this, "Error Swapping Fragment", Toast.LENGTH_SHORT).show();
            return;
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,frag).addToBackStack(null).commit();
    }



}
