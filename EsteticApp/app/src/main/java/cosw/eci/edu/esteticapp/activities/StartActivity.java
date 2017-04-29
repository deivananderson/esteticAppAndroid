package cosw.eci.edu.esteticapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cosw.eci.edu.esteticapp.R;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "StartActivity";
    private static final int REQUEST_SIGNUP = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        inicializeProgress();

    }

    private void inicializeProgress() {
        final ProgressDialog progressDialog = new ProgressDialog(StartActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential",123);
                        String data = mPrefs.getString("email", "");
                        if(data == ""){
                            onLoginFailed();
                        }else{
                            onLoginSuccess(data);
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    private void onLoginSuccess(String email) {

        Intent intent = new Intent(getApplicationContext(), MainClienteActivity.class);
        intent.putExtra("name","Cliente");
        intent.putExtra("email",email);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

    public void onLoginFailed() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

}
