package cosw.eci.edu.esteticapp.activities.professional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cosw.eci.edu.esteticapp.R;

public class AddServicesActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private String name;
    private String email;
    private TextView nameHome;
    private TextView emailHome;
    private View hairdressing;
    private View manicure;
    private View massage;
    private View depilation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);
        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential",123);
        email = mPrefs.getString("email", "");
        name = mPrefs.getString("name", "");
        servicesTask();
    }

    private void servicesTask() {
        hairdressing = (View)findViewById(R.id.layout_hairdressing);
        manicure = (View)findViewById(R.id.layout_manicure);
        massage = (View)findViewById(R.id.layout_massage);
        depilation = (View)findViewById(R.id.layout_depilation);
        hairdressing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddServiceSelectedActivity.class);
                intent.putExtra("service","Hairdressing");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        manicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddServiceSelectedActivity.class);
                intent.putExtra("service","Manicure");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddServiceSelectedActivity.class);
                intent.putExtra("service","Massage");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
        depilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddServiceSelectedActivity.class);
                intent.putExtra("service","Depilation");
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }


}
