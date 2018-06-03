package com.example.vmac.WatBot.Activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmac.WatBot.Fragments.CarrerasTecnFragment;
import com.example.vmac.WatBot.Fragments.PfrFragment;
import com.example.vmac.WatBot.Fragments.ChatFragment;
import com.example.vmac.WatBot.Fragments.CursosFragment;
import com.example.vmac.WatBot.R;

public class PrincipalActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Button  hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        // Set drawer toggle icon
      /*  final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }*/


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        CursosFragment fragment2 = new CursosFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content, fragment2).addToBackStack("tag").commit();
                        break;
                    case R.id.nav_carprof:
                        PfrFragment fragment1 = new PfrFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content, fragment1).addToBackStack("tag").commit();
                        break;
                    case R.id.nav_gallery:
                        ChatFragment fragment = new ChatFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content, fragment).addToBackStack("tag").commit();
                        break;
                    case R.id.nav_locations:
                        CarrerasTecnFragment fragment3 = new CarrerasTecnFragment();
                        fragmentManager.beginTransaction().replace(R.id.main_content, fragment3).addToBackStack("tag").commit();
                        break;

                    case R.id.nav_logout:
                        Toast.makeText(PrincipalActivity.this, "Do logout...", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
        // Change navigation header information
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText("Liset Cayhualla");

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText("liset.cayhualla@tecsup.edu.pe");

        //  LocalDate  ahora = LocalDate.now();
        //System.out.println(ahora);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
