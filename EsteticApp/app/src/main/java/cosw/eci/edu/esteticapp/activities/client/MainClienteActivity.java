package cosw.eci.edu.esteticapp.activities.client;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.activities.LoginActivity;

public class MainClienteActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_SIGNUP = 0;
    private String name;
    private String email;
    private TextView nameHome;
    private TextView emailHome;
    private View hairdressing;
    private View manicure;
    private View massage;
    private View depilation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential",123);
        email = mPrefs.getString("email", "");
        name = mPrefs.getString("name", "");
        buttonHome();
        configBar(toolbar);
        servicesTask();
    }

    /**
     * Action in click on layout of services
     */
    private void servicesTask() {
        hairdressing = (View)findViewById(R.id.layout_hairdressing);
        manicure = (View)findViewById(R.id.layout_manicure);
        massage = (View)findViewById(R.id.layout_massage);
        depilation = (View)findViewById(R.id.layout_depilation);
        hairdressing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPrefs = getSharedPreferences("esteticapp.cliente", 123);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString("service", "Hairdressing");
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        manicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPrefs = getSharedPreferences("esteticapp.cliente", 123);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString("service", "Manicure");
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPrefs = getSharedPreferences("esteticapp.cliente", 123);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString("service", "Massage");
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        depilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPrefs = getSharedPreferences("esteticapp.cliente", 123);
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString("service", "Depilation");
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    private void buttonHome() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No reservations", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void configBar(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);
        nameHome = (TextView)view.findViewById(R.id.name);
        emailHome = (TextView)view.findViewById(R.id.email);
        nameHome.setText(name);
        emailHome.setText(email);
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation_services view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_reservation) {
            Intent intent = new Intent(getApplicationContext(), ReservationClientActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        } else if (id == R.id.nav_account) {
            Intent intent = new Intent(getApplicationContext(), AccountClientActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            startActivityForResult(intent, REQUEST_SIGNUP);
        }  else if (id == R.id.nav_logout) {
            SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential", 123);
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString("email", "");
            editor.putString("rol", "");
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
