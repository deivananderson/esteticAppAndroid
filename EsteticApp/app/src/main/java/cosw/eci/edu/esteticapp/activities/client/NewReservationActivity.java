package cosw.eci.edu.esteticapp.activities.client;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cosw.eci.edu.esteticapp.R;

public class NewReservationActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private String nameProfessional;
    private String emailProfessional;
    private TextView name;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation);
        nameProfessional = getIntent().getStringExtra("nameProfessional");
        emailProfessional = getIntent().getStringExtra("email");
        name = (TextView)findViewById(R.id.nameProfessional);
        email = (TextView) findViewById(R.id.email);
        name.setText(nameProfessional);
        email.setText(emailProfessional);
    }

    public void reserve(View view) {

        new AlertDialog.Builder(this)
                .setTitle("New Reserve")
                .setMessage("Want to create the reservation?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainClienteActivity.class);
                        startActivityForResult(intent, REQUEST_SIGNUP);
                        Toast.makeText(getBaseContext(), "Reserve created", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
}
