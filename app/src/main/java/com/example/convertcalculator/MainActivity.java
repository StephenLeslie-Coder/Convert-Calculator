package com.example.convertcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private tab4 recycleTest;
    LinkedList<String> myLinkedList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout= findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);

        TabLayout tabLayout = findViewById(R.id.myTabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Kg to Lbs"));
        tabLayout.addTab(tabLayout.newTab().setText("Km to Miles"));
        tabLayout.addTab(tabLayout.newTab().setText("Cm to Feet"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        /*mRecyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        final ViewPager viewPager = findViewById(R.id.myViewPager);
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==3){
                    tab4 fragment= (tab4) getSupportFragmentManager().findFragmentById(R.id.troubleFragment);
                   if(fragment!=null) {
                       Log.d("work please", "onTabSelected: fragment selected");
                       fragment.myList.clear();
                       fragment.myList.addAll(myLinkedList);
                       fragment.updateData();
                   }



                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

    actionBarDrawerToggle.syncState();
    }
    public void updateList(String message){
        if(myLinkedList.size()<1) {
            myLinkedList.add(message);
        }else{
            myLinkedList.addLast(message);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

