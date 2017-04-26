package cosw.eci.edu.esteticapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import cosw.eci.edu.esteticapp.R;

public class AccountClientActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private EditText email;
    private EditText password;
    private EditText name;
    private int modified;
    private String nameR;
    private String emailR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_client);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        modified = 0;
        nameR = getIntent().getStringExtra("name");
        emailR = getIntent().getStringExtra("email");
        name.setText(nameR);
        email.setText(emailR);
        password.setText("12345");
        buttonModified();
    }

    private void buttonModified() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modified==0){
                    email.setEnabled(true);
                    password.setEnabled(true);
                    name.setEnabled(true);
                    modified =1;
                }else {
                    email.setEnabled(false);
                    password.setEnabled(false);
                    name.setEnabled(false);
                    modified =0;
                }
            }
        });
    }

}
