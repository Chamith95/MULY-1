package cafe.adriel.androidaudiorecorder.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.app.ProgressDialog;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class login extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private TextInputLayout textInputPassword;
    private TextInputLayout textInputEmail;
    private Button buttonlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputPassword = (TextInputLayout) findViewById(R.id.input_password);
        textInputEmail = (TextInputLayout) findViewById(R.id.input_email);
        buttonlogin = findViewById(R.id.btn_login);

        buttonlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        buttonlogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

       String password = textInputPassword.getEditText().getText().toString().trim();
       String email = textInputEmail.getEditText().getText().toString().trim();


        //   TODO: Implement your own authentication logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        confirm();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 2000);
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
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        buttonlogin.setEnabled(true);
//        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        buttonlogin.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = textInputEmail.getEditText().getText().toString();
        String password = textInputPassword.getEditText().getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputEmail.setError("Enter a valid email address");
            valid = false;
        } else {
            textInputEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            textInputPassword.setError("Password must be 4 to 10 characters");
            valid = false;
        } else {
            textInputPassword.setError(null);
        }

       return valid;
    }

    public void confirm(){
        String email = textInputEmail.getEditText().getText().toString();
        String password = textInputPassword.getEditText().getText().toString();

        if(( email.equals("student@gmail.com"))&&(password.equals("12345"))){
            Intent intent1=new Intent(login.this,StudentMActivity.class);
            startActivity(intent1);
            onLoginSuccess();
        }
        else if(( email.equals("teacher@gmail.com"))&&(password.equals("12345"))){
            Intent intent2=new Intent(login.this,TeacherMain.class);
            startActivity(intent2);
            onLoginSuccess();
        }
        else{
            onLoginFailed();
        }

    }

    public void popsignup(View v){
        Intent intent3=new Intent(login.this,signup.class);
        startActivity(intent3);
    }
}


