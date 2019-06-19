package com.thecatalyst.catalyst.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;
import com.thecatalyst.catalyst.R;


import java.util.Objects;

import butterknife.BindView;

public class TaskScreenActivity extends AppCompatActivity {

    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @BindView(R.id.recycler)
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    View view;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_screen);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.navigation_view);
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
        loadFragment(new CurrentFragment());
        getSupportActionBar().setTitle("Current Projects");

        navigationView.setCheckedItem(R.id.current);

        navigationView.setNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()){
                case R.id.current:
                    loadFragment(new CurrentFragment());
                    getSupportActionBar().setTitle("Current Projects");
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;

                case R.id.complete:
                    loadFragment(new CompletedFragment());
                    getSupportActionBar().setTitle("Completed Projects");
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;

//                case R.id.hold:
//                    loadFragment(new HoldFragment());
//                    getSupportActionBar().setTitle("Dumped Projects");
//                    menuItem.setChecked(true);
//                    drawerLayout.closeDrawers();
//                    return true;

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

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container,fragment);
        Log.e("TAG", "TRANSACTION: "+fragment );
        transaction.commit();
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
