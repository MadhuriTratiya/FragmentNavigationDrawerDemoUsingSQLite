package madhuri.com.craftzone.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import madhuri.com.craftzone.Fragments.contactusfragment;
import madhuri.com.craftzone.Fragments.mattressfragment;
import madhuri.com.craftzone.Fragments.modernkitchenfragment;
import madhuri.com.craftzone.Fragments.pillowfragment;
import madhuri.com.craftzone.Fragments.sliderfragment;
import madhuri.com.craftzone.Fragments.sofaFragment;
import madhuri.com.craftzone.R;

public class Containmain extends AppCompatActivity {
    //ActivityContentmainBinding binding;
        Toolbar toolbar;
        DrawerLayout drawerLayout;
        NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentmain);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.tools);


        //Set up toolbar work like actionbar
       setSupportActionBar(toolbar);

        //Method of Toggle Listner
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Containmain.this,
                drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        //add in drawer layout
        drawerLayout.addDrawerListener(toggle);

        //manage stack to sync
        toggle.syncState();

        //add click on it select one from multiple
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.sofa) {
                    loadFragment(new sofaFragment());
                    Toast.makeText(Containmain.this, "Sofa", Toast.LENGTH_LONG).show();
                } else if (id == R.id.mattress) {
                  loadFragment(new mattressfragment());
                 Toast.makeText(Containmain.this, "mattress", Toast.LENGTH_LONG).show();
                } else if(id == R.id.pillow){
                    loadFragment(new pillowfragment());
                    Toast.makeText(Containmain.this, "pillow", Toast.LENGTH_LONG).show();
                } else if (id == R.id.modernkitchen) {
                    loadFragment(new modernkitchenfragment());
                    Toast.makeText(Containmain.this, "ModernBed", Toast.LENGTH_LONG).show();
                }  else if (id == R.id.slider) {
                    loadFragment(new sliderfragment());
                    Toast.makeText(Containmain.this, "Slider Drawer", Toast.LENGTH_LONG).show();
                } else
                {
                    loadFragment(new contactusfragment());
                    Toast.makeText(Containmain.this, "Contact Us", Toast.LENGTH_LONG).show();
                }
                return true;
            }
            private void loadFragment(Fragment fragment){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.container,fragment);
                ft.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}