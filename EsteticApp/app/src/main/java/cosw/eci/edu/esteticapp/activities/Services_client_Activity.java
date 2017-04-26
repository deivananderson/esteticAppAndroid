package cosw.eci.edu.esteticapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;

public class Services_client_Activity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private TextView mTextMessage;
    private String service;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_client_);
        service = getIntent().getStringExtra("service");
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(service);
        buttonTop();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void buttonTop() {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent = new Intent(getApplicationContext(), MainClienteActivity.class);
                        startActivityForResult(intent, REQUEST_SIGNUP);
                        return true;
                    case R.id.navigation_reservation:
                        intent = new Intent(getApplicationContext(), ReservationClientActivity.class);
                        startActivityForResult(intent, REQUEST_SIGNUP);
                        return true;
                }
                return false;
            }

        };
    }

}
