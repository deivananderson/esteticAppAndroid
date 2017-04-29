package cosw.eci.edu.esteticapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.services.MessagesAdapterReservations;

public class ReservationClientActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    private RecyclerView recyclerView;
    MessagesAdapterReservations messagesAdapterServices = new MessagesAdapterReservations(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_client);
        mTextMessage = (TextView) findViewById(R.id.message);
        buttonTop();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter(messagesAdapterServices);
    }

    /**
     * Action by button foot
     */
    private void buttonTop() {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent = new Intent(getApplicationContext(), MainClienteActivity.class);
                        startActivityForResult(intent, REQUEST_SIGNUP);
                        return true;
                }
                return false;
            }

        };
    }

}
