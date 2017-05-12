package cosw.eci.edu.esteticapp.activities.professional;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.services.MessagesAdapterServicesProfessional;
import cosw.eci.edu.esteticapp.services.Service;

public class Services_professional_Activity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    private RecyclerView recyclerView;
    MessagesAdapterServicesProfessional messagesAdapterServicesProfessional = new MessagesAdapterServicesProfessional(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_professional_);
        configureRecyclerView();
        dataTest();
    }

    public void addServices(View view) {
        Intent intent = new Intent(getApplicationContext(), AddServicesActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter(messagesAdapterServicesProfessional);
    }

    private void dataTest(){
        Service s1 = new Service("Corte masculino","$15000","Corte para hombres");
        Service s2 = new Service("Corte dama","$25000","Corte para todas las mujeres");
        Service s3 = new Service("Corte infantil","$15000","Corte infantil todo tipo");
        Service s4 = new Service("Manicure","$15000","Decoracion para tus manos");
        Service s5 = new Service("Pedicure","$35000","Decoracion para tus pies");
        Service s6 = new Service("Tintura","$15000","Tintes");
        Service s7 = new Service("Alizado","$13000","liso");
        Service s8 = new Service("Peinado 15","$33000","especial");
        Service s9 = new Service("Corta aunas","$13000","liso");
        Service s10 = new Service("Peinado 30","$33000","especial");
        messagesAdapterServicesProfessional.addMessage(s1);
        messagesAdapterServicesProfessional.addMessage(s2);
        messagesAdapterServicesProfessional.addMessage(s3);
        messagesAdapterServicesProfessional.addMessage(s4);
        messagesAdapterServicesProfessional.addMessage(s5);
        messagesAdapterServicesProfessional.addMessage(s6);
        messagesAdapterServicesProfessional.addMessage(s7);
        messagesAdapterServicesProfessional.addMessage(s8);
        messagesAdapterServicesProfessional.addMessage(s9);
        messagesAdapterServicesProfessional.addMessage(s10);
    }

}
