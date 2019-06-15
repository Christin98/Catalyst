package com.thecatalyst.catalyst.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;
import com.thecatalyst.catalyst.Fragment.HoldFragment;
import com.thecatalyst.catalyst.R;
import butterknife.BindView;

public class TaskScreenActivity extends AppCompatActivity {

    @BindView(R.id.recycler_child)
    RecyclerView recyclerViewchild;
    @BindView(R.id.recycler)
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_screen);

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
