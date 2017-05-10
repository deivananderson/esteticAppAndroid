package cosw.eci.edu.esteticapp.activities.client;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import cosw.eci.edu.esteticapp.R;
import cosw.eci.edu.esteticapp.services.MessagesAdapterNewReservation;
import cosw.eci.edu.esteticapp.services.Service;

public class NewReservationActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private String nameProfessional;
    private String emailProfessional;
    private EditText address;
    private EditText numberPhone;
    private TextView name;
    private TextView email;
    private TextView cost;
    private Button reserve;
    private ImageView image;
    private Bitmap imageView;
    private RecyclerView recyclerView;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    MessagesAdapterNewReservation messagesAdapterNewReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation);
        nameProfessional = getIntent().getStringExtra("nameProfessional");
        emailProfessional = getIntent().getStringExtra("email");
        imageView = (Bitmap) getIntent().getParcelableExtra("BitmapImage");
        name = (TextView)findViewById(R.id.nameProfessional);
        email = (TextView) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        numberPhone = (EditText) findViewById(R.id.numberPhone);
        reserve = (Button) findViewById(R.id.reserve);
        cost = (TextView) findViewById(R.id.total);
        image = (ImageView)findViewById(R.id.circleView);
        image.setImageBitmap(imageView);
        name.setText(nameProfessional);
        email.setText(emailProfessional);
         messagesAdapterNewReservation = new MessagesAdapterNewReservation(this,cost);
        configureRecyclerView();
        dataTest();
        configCalendar();
    }

    private void configCalendar() {
        dateView = (TextView) findViewById(R.id.date);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Select the date",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void dataTest() {
        Service s1 = new Service("Corte nino","12000","hay no mas");
        Service s2 = new Service("Corte Adulto","15000","hay no mas");
        Service s3 = new Service("Corte Mujer","15000","hay no mas");
        Service s4 = new Service("Alizado","25000","hay no mas");
        Service s5 = new Service("Manicure","22000","hay no mas");
        Service s6 = new Service("Tintura","5000","hay no mas");
        Service s7 = new Service("Masajes total","55000","hay no mas");
        Service s8 = new Service("Crespos","15000","hay no mas");
        Service s9 = new Service("Maquillaje","25000","hay no mas");
        Service s10 = new Service("Depilación","35000","hay no mas");
        messagesAdapterNewReservation.addMessage(s1);
        messagesAdapterNewReservation.addMessage(s2);
        messagesAdapterNewReservation.addMessage(s3);
        messagesAdapterNewReservation.addMessage(s4);
        messagesAdapterNewReservation.addMessage(s5);
        messagesAdapterNewReservation.addMessage(s6);
        messagesAdapterNewReservation.addMessage(s7);
        messagesAdapterNewReservation.addMessage(s8);
        messagesAdapterNewReservation.addMessage(s9);
        messagesAdapterNewReservation.addMessage(s10);
    }

    public void reserve(View view) {

        String address = this.address.getText().toString();
        String numberPhone = this.numberPhone.getText().toString();

        Log.d("address", address);

        if (validate()){
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
        }else{
            onLoginFailed();
            return;
        }
    }

    /**
     * Validate the login structure in login
     * @return true if data in login is correct, or false is data in login is incorrect
     */
    public boolean validate() {
        String addressValor = this.address.getText().toString();
        String numberPhone = this.numberPhone.getText().toString();
        String date = this.dateView.getText().toString();
        System.out.println("valores"+address+numberPhone);
        boolean valid = true;

        if(addressValor.isEmpty()){
            this.address.setError("Address is need");
            valid = false;
        }else{
            this.address.setError(null);
        }
        if(date.isEmpty()){
            this.dateView.setError("Date is need");
            valid = false;
        }else{
            this.address.setError(null);
        }
        if(numberPhone.isEmpty()){
            this.numberPhone.setError("Number phone is need");
            valid = false;
        }else{
            this.numberPhone.setError(null);
        }
        return valid;
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Emply spaces", Toast.LENGTH_LONG).show();
    }

    private void configureRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setReverseLayout( true );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setAdapter(messagesAdapterNewReservation);
    }

}
