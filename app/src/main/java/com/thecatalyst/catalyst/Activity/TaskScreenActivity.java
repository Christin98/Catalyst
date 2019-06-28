package com.thecatalyst.catalyst.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.thecatalyst.catalyst.Adapter.ViewPagerAdapter;
import com.thecatalyst.catalyst.Fragment.ChatFragment;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;
import com.thecatalyst.catalyst.R;


import java.util.Objects;

import butterknife.BindView;

public class TaskScreenActivity extends AppCompatActivity {

    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @BindView(R.id.recycler)
    CollapsingToolbarLayout collapsing_toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;
    View view;
    private String[] pageTitle = {"Current", "Submitted", "Chat"};
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_screen);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.navigation_view);
        collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.toolbar);
        view = navigationView.getHeaderView(0);
        TextView usern = view.findViewById(R.id.usertv_head);
        setSupportActionBar(toolbar);

         String user = sharedPreferences.getString("Username","def");
//         usern.setText(user);
//        Log.e("TAG", "onCreate: "+user_name );
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        usern.setText(user);
        tabLayout.addTab(tabLayout.newTab().setText(pageTitle[0]));
        tabLayout.addTab(tabLayout.newTab().setText(pageTitle[1]));
        tabLayout.addTab(tabLayout.newTab().setText(pageTitle[2]));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        loadFragment(new CurrentFragment());
////        getSupportActionBar().setTitle("Current Projects");

        assert navigationView != null;
        navigationView.setCheckedItem(R.id.current);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        tabLayout.setSelectedTabIndicatorGravity(TabLayout.INDICATOR_GRAVITY_BOTTOM);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        navigationView.setNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()){
                case R.id.current:
                    viewPager.setCurrentItem(0);
                    return true;

                case R.id.complete:
                    viewPager.setCurrentItem(1);
                    return true;

                case R.id.logout:
                    sharedPreferences.edit().putBoolean("logged",false).apply();
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    return true;

                case R.id.share:
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Check it out. Your message goes here";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Sharing App Using"));
                    return true;
            }
            return false;
        });
    }



    @Override
    public void onBackPressed() {
        assert drawerLayout != null;
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
