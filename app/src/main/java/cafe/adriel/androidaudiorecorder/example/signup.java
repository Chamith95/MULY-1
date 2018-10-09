package cafe.adriel.androidaudiorecorder.example;

import android.os.Bundle;
import android.util.Patterns;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;


public class signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextInputLayout textInputUsername1;
    private TextInputLayout textInputEmail1;
    private TextInputLayout textInputTelephone1;
    private TextInputLayout password;
    private TextInputLayout confirmpassword;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textInputUsername1 = (TextInputLayout) findViewById(R.id.text_input_username1);
        textInputEmail1 = (TextInputLayout) findViewById(R.id.text_input_email1);
        textInputTelephone1= (TextInputLayout) findViewById(R.id.text_input_telephone1);
        password= (TextInputLayout) findViewById(R.id.text_input_password1);
        confirmpassword= (TextInputLayout) findViewById(R.id.text_input_passwordConfirm1);
//Spinners
        Spinner Role=findViewById(R.id.Role);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.Role,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Role.setAdapter(adapter1);
        Role.setOnItemSelectedListener(this);

        Spinner Gender=findViewById(R.id.Gender);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Gender,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender.setAdapter(adapter2);
        Gender.setOnItemSelectedListener(this);
    }

    // Basic Email validation
    private boolean validateEmail() {
        String emailInput = textInputEmail1.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            textInputEmail1.setError("Field can't be Empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail1.setError("Please Enter valid email adress");
            return false;
        } else {
            textInputEmail1.setError(null);
            return true;
        }
    }

    //Basic username Validation
    private boolean validateUsername() {
        String usernameinput = textInputUsername1.getEditText().getText().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsername1.setError("Field can't be Empty");
            return false;
        } else if (usernameinput.length() > 10) {
            textInputUsername1.setError("Username Too long");
            return false;
        } else {
            textInputUsername1.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }


    // Basic Telephone Number validation
    private boolean validateTelephone() {
        String TelephoneInput = textInputTelephone1.getEditText().getText().toString().trim();
        if (TelephoneInput.isEmpty()) {
            textInputTelephone1.setError("Field can't be Empty");
            return false;
        } else if (TelephoneInput.length() > 13) {
            textInputTelephone1.setError("Telephone Number Too long");
            return false;
        } else {
            textInputTelephone1.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateTelephone() | !validateUsername()| !validatePassword()) {
            return;

        }

        String input = "Username" + textInputUsername1.getEditText().getText().toString();
        input += "\n";
        input += "Email" + textInputEmail1.getEditText().getText().toString();
        input += "\n";
        input += "Telephone" + textInputTelephone1.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + password.getEditText().getText().toString();

        Toast.makeText(this, "input", Toast.LENGTH_SHORT).show();


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
