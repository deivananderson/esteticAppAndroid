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
import cosw.eci.edu.esteticapp.services.MessagesAdapterServices;

public class AddServiceSelectedActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private TextView mTextMessage;
    private String service;
    private RecyclerView recyclerView;
    MessagesAdapterServices messagesAdapterServices = new MessagesAdapterServices(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_selected);
        service = getIntent().getStringExtra("service");
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(service);
        configureRecyclerView();
        //dataTest();
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
        recyclerView.setAdapter(messagesAdapterServices);
    }


}
