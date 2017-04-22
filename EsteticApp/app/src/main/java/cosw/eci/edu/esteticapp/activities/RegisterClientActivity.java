package cosw.eci.edu.esteticapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;

public class RegisterClientActivity extends AppCompatActivity {

    private static final String TAG = "RegisterClientActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Button register;
    private TextView client;
    private TextView professional;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerclient);
        professional = (TextView)findViewById(R.id.professional);
        client = (TextView)findViewById(R.id.client);
        listenerTabCliente();
        listenerTabProfessional();
    }

    private void listenerTabProfessional() {
        professional.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterProfessionalActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    private void listenerTabCliente() {

    }
}
