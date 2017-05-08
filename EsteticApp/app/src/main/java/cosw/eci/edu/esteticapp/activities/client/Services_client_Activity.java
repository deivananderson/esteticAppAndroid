package cosw.eci.edu.esteticapp.activities.client;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        SharedPreferences mPrefs = getSharedPreferences("esteticapp.cliente", 123);
        service =  mPrefs.getString("service", "");
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(service);
        buttonTop();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        configureRecyclerView();
        dataTest();

    }

    private void dataTest() {
        Bitmap bm1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar1);
        Bitmap bm2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar2);
        Bitmap bm3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar3);
        Bitmap bm4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar4);
        Bitmap bm5 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar5);
        Bitmap bm6 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar6);
        Bitmap bm7 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar7);
        Bitmap bm8 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar8);
        Bitmap bm9 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar9);
        Bitmap bm10 = BitmapFactory.decodeResource(this.getResources(), R.drawable.avatar10);
        Professional p1 = new Professional("Maria Camila", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p2 = new Professional("Joana Melo", "joana@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p3 = new Professional("Loca Gracia", "HAY@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p4 = new Professional("Elena Sua", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p5 = new Professional("Jenny Camila", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p6 = new Professional("Paula Andrea", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p7 = new Professional("Camila Rodriguez", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p8 = new Professional("Maria Sofia", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p9 = new Professional("Paola Andrea", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        Professional p10 = new Professional("Karina Zuam", "jacinto@mail.com","Manicure, Pedicure, Cortes, Masajes");
        p1.setImageUrl(bm1);
        p2.setImageUrl(bm2);
        p3.setImageUrl(bm3);
        p4.setImageUrl(bm4);
        p5.setImageUrl(bm5);
        p6.setImageUrl(bm6);
        p7.setImageUrl(bm7);
        p8.setImageUrl(bm8);
        p9.setImageUrl(bm9);
        p10.setImageUrl(bm10);
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
