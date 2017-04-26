package cosw.eci.edu.esteticapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;

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
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
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
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                intent.putExtra("service","Hairdressing");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        manicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                intent.putExtra("service","Manicure");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                intent.putExtra("service","Massage");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        depilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Services_client_Activity.class);
                intent.putExtra("service","Depilation");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    private void buttonHome() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Select one of the services", Snackbar.LENGTH_LONG)
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_reservation) {
            Intent intent = new Intent(getApplicationContext(), ReservationClientActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        } else if (id == R.id.nav_account) {

        }  else if (id == R.id.nav_logout) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
