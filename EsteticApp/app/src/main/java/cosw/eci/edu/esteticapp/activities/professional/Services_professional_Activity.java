package cosw.eci.edu.esteticapp.activities.professional;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cosw.eci.edu.esteticapp.R;

public class Services_professional_Activity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_professional_);
    }

    public void addServices(View view) {
        Intent intent = new Intent(getApplicationContext(), AddServicesActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }
}
