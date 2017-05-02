package cosw.eci.edu.esteticapp.activities.client;

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
import cosw.eci.edu.esteticapp.services.MessagesAdapterServices;
import cosw.eci.edu.esteticapp.services.Professional;

public class Services_client_Activity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private TextView mTextMessage;
    private String service;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    private RecyclerView recyclerView;
    MessagesAdapterServices messagesAdapterServices = new MessagesAdapterServices(this);

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
        configureRecyclerView();
        dataTest();

    }

    private void dataTest() {
        Professional p1 = new Professional("Jasinto", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p2 = new Professional("Joana Melo", "joana@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p3 = new Professional("HyamEtOCO", "HAY@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p4 = new Professional("JAJAJAJ", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p5 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p6 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p7 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p8 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p9 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p10 = new Professional("LOL", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        messagesAdapterServices.addMessage(p1);
        messagesAdapterServices.addMessage(p2);
        messagesAdapterServices.addMessage(p3);
        messagesAdapterServices.addMessage(p4);
        messagesAdapterServices.addMessage(p5);
        messagesAdapterServices.addMessage(p6);
        messagesAdapterServices.addMessage(p7);
        messagesAdapterServices.addMessage(p8);
        messagesAdapterServices.addMessage(p9);
        messagesAdapterServices.addMessage(p10);
    }

    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter(messagesAdapterServices);
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
