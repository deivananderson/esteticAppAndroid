package cosw.eci.edu.esteticapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private String passwordR;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_client);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        save = (Button)findViewById(R.id.save);
        save.setVisibility(Button.INVISIBLE);
        modified = 0;
        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential",123);
        String emailR = mPrefs.getString("email", "");
        String nameR = mPrefs.getString("name", "");
        String passwordR = mPrefs.getString("password", "");
        name.setText(nameR);
        email.setText(emailR);
        password.setText(passwordR);
        buttonModified();
    }

    private void buttonModified() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modified==0){
                    save.setVisibility(Button.VISIBLE);
                    email.setEnabled(true);
                    password.setEnabled(true);
                    name.setEnabled(true);
                    modified =1;
                }else {
                    save.setVisibility(Button.INVISIBLE);
                    email.setEnabled(false);
                    password.setEnabled(false);
                    name.setEnabled(false);
                    modified =0;
                }
            }
        });
    }


    public void saveData(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Data update")
                .setMessage("Secure data update?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        email = (EditText)findViewById(R.id.email);
                        password = (EditText)findViewById(R.id.password);
                        name = (EditText)findViewById(R.id.name);
                        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential", 123);
                        SharedPreferences.Editor editor = mPrefs.edit();
                        editor.putString("name", name.getText().toString());
                        editor.putString("email", email.getText().toString());
                        editor.putString("password", password.getText().toString());
                        editor.putString("rol", "client");
                        editor.commit();
                        save.setVisibility(Button.INVISIBLE);
                        email.setEnabled(false);
                        password.setEnabled(false);
                        name.setEnabled(false);
                        modified =0;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences mPrefs = getSharedPreferences("esteticapp.login.credential",123);
                        String emailR = mPrefs.getString("email", "");
                        String nameR = mPrefs.getString("name", "");
                        String passwordR = mPrefs.getString("password", "");
                        name.setText(nameR);
                        email.setText(emailR);
                        password.setText(passwordR);
                        save.setVisibility(Button.INVISIBLE);
                        email.setEnabled(false);
                        password.setEnabled(false);
                        name.setEnabled(false);
                        modified =0;
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
