package cosw.eci.edu.esteticapp.activities.professional;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.services.MessagesAdapterServiceSelected;
import cosw.eci.edu.esteticapp.services.Service;

public class AddServiceSelectedActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private TextView mTextMessage;
    private String service;
    private RecyclerView recyclerView;
    MessagesAdapterServiceSelected messagesAdapterServiceSelected = new MessagesAdapterServiceSelected(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_selected);
        service = getIntent().getStringExtra("service");
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(service);
        configureRecyclerView();
        dataTest();
        configButton();
    }

    private void configButton() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter(messagesAdapterServiceSelected);
    }

    private void dataTest(){
        Service s1 = new Service("Corte masculino","","");
        Service s2 = new Service("Corte dama","","");
        Service s3 = new Service("Corte infantil","","");
        Service s4 = new Service("Manicure","","");
        Service s5 = new Service("Pedicure","","");
        Service s6 = new Service("Tintura","","");
        Service s7 = new Service("Alizado","","");
        Service s8 = new Service("Peinado 15","","");
        messagesAdapterServiceSelected.addMessage(s1);
        messagesAdapterServiceSelected.addMessage(s2);
        messagesAdapterServiceSelected.addMessage(s3);
        messagesAdapterServiceSelected.addMessage(s4);
        messagesAdapterServiceSelected.addMessage(s5);
        messagesAdapterServiceSelected.addMessage(s6);
        messagesAdapterServiceSelected.addMessage(s7);
        messagesAdapterServiceSelected.addMessage(s8);
    }
}
