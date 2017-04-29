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
import cosw.eci.edu.esteticapp.services.Reservation;

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
        dataTest();
    }

    private void dataTest() {
        Reservation r1 = new Reservation("Jasinto","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r2 = new Reservation("Perez Sosa","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$20.000","Active");
        Reservation r3 = new Reservation("Maria camila","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$450.000","Active");
        Reservation r4 = new Reservation("Peluqueria lino","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r5 = new Reservation("Jose martin","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r6 = new Reservation("Jasinto cAMILO","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r7 = new Reservation("jOANA MELO","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r8 = new Reservation("Jasinto","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r9 = new Reservation("Jasinto","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        Reservation r10 = new Reservation("Jasinto","Manicure, Pedicure, Cortes, Masajes","12/12/2017","$200.000","Active");
        messagesAdapterServices.addMessage(r1);
        messagesAdapterServices.addMessage(r2);
        messagesAdapterServices.addMessage(r3);
        messagesAdapterServices.addMessage(r4);
        messagesAdapterServices.addMessage(r5);
        messagesAdapterServices.addMessage(r6);
        messagesAdapterServices.addMessage(r7);
        messagesAdapterServices.addMessage(r8);
        messagesAdapterServices.addMessage(r9);
        messagesAdapterServices.addMessage(r10);

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
