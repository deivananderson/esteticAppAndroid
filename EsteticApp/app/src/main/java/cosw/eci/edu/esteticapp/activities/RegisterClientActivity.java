package cosw.eci.edu.esteticapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.services.Client;

public class RegisterClientActivity extends AppCompatActivity {

    private static final String TAG = "RegisterClientActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Button register;
    private TextView professional;
    private EditText email;
    private EditText password;
    private TextView loginRegister;
    private EditText name;
    private ArrayList<Client> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerclient);
        register = (Button)findViewById(R.id.register);
        professional = (TextView)findViewById(R.id.professional);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginRegister = (TextView)findViewById(R.id.loginAccount);
        name = (EditText)findViewById(R.id.name);
        clients = new ArrayList<>();
        listenerRegister();
        listenerTabProfessional();
        listenerLoginAccount();
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

    private void listenerRegister() {
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                regist();
            }
        });
    }

    /**
     * Listener for a login in log
     */
    private void listenerLoginAccount() {
        loginRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    private void regist (){
        Log.d(TAG, "Register");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        register.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterClientActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        String name = this.name.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        Client client = new Client(name,email,password);
        clients.add(client);

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        //onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    /**
     * Validate the login structure in login
     * @return true if data in login is correct, or false is data in login is incorrect
     */
    public boolean validate() {
        boolean valid = true;

        String name = this.name.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            this.email.setError("enter a valid email address");
            valid = false;
        } else {
            this.email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            this.password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            this.email.setError(null);
        }
        if(name.isEmpty() || name.length()<4){
            this.name.setError("name is need");
            valid = false;
        }else{
            this.name.setError(null);
        }
        return valid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainClientActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        String name = this.name.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential", 123);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("role", "client");
        editor.commit();

        register.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(), MainClienteActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        register.setEnabled(true);
    }

}
