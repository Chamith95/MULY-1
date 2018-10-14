package cafe.adriel.androidaudiorecorder.example;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

public class edit_profile extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textInputUsername = (TextInputLayout) findViewById(R.id.text_input_username);
        textInputEmail = (TextInputLayout) findViewById(R.id.text_input_email);
        textInputTelephone = (TextInputLayout) findViewById(R.id.text_input_telephone);


    }

    // Basic Email validation
    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be Empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please Enter valid email adress");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    //Basic username Validation
    private boolean validateUsername() {
        String usernameinput = textInputUsername.getEditText().getText().toString().trim();
        if (usernameinput.isEmpty()) {
            textInputUsername.setError("Field can't be Empty");
            return false;
        } else if (usernameinput.length() > 10) {
            textInputUsername.setError("Username Too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    // Basic Telephone Number validation
    private boolean validateTelephone() {
        String TelephoneInput = textInputTelephone.getEditText().getText().toString().trim();
        if (TelephoneInput.isEmpty()) {
            textInputTelephone.setError("Field can't be Empty");
            return false;
        } else if (TelephoneInput.length() > 13) {
            textInputTelephone.setError("Telephone Number Too long");
            return false;
        } else {
            textInputTelephone.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateTelephone() | !validateUsername()) {
            return;

        }

        String input = "Username" + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Email" + textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Telephone" + textInputTelephone.getEditText().getText().toString();

        Toast.makeText(this, "input", Toast.LENGTH_SHORT).show();


    }
}
