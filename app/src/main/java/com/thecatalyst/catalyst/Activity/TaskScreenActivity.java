package com.thecatalyst.catalyst.Activity;
<<<<<<< HEAD
import androidx.annotation.NonNull;
=======

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import android.content.SharedPreferences;
import android.content.Intent;
=======

import android.content.Intent;
import android.content.SharedPreferences;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
<<<<<<< HEAD
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;
import com.thecatalyst.catalyst.Fragment.HoldFragment;
import com.thecatalyst.catalyst.R;
=======
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;
import com.thecatalyst.catalyst.R;


import java.util.Objects;

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import butterknife.BindView;

public class TaskScreenActivity extends AppCompatActivity {

    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @BindView(R.id.recycler)
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
<<<<<<< HEAD
=======
    View view;
    SharedPreferences sharedPreferences;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_screen);
<<<<<<< HEAD

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        loadFragment(new CurrentFragment());
        getSupportActionBar().setTitle("Current Projects");
        navigationView.setCheckedItem(R.id.current);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

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

                    case R.id.share:
                        getSupportActionBar().setTitle("Share this App");
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        drawerLayout.getOverlay();
                        startActivity(Intent.createChooser(intent,"Share using"));



//                    case R.id.hold:
//                        loadFragment(new HoldFragment());
//                        getSupportActionBar().setTitle("Dumped Projects");
//                        menuItem.setChecked(true);
//                        drawerLayout.closeDrawers();
//                        return true;
                    case R.id.logout:
                        sharedPreferences.edit().putBoolean("logged",false).apply();
                        Intent intent1 = new Intent(TaskScreenActivity.this,LoginActivity.class);
                        startActivity(intent1);
                       return true;
                }
                return false;
            }
=======
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
            }
            return false;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
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
