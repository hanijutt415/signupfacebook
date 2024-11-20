package com.enfotriz.signupfacebook;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    private EditText emailLogin, passwordLogin;
    private View loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        // Assuming Sharedpref is a custom class for handling shared preferences
        Sharedpref sharedPreferences = new Sharedpref(this);
        emailLogin = findViewById(R.id.loginemail);
        passwordLogin = findViewById(R.id.loginpassword);
        loginBtn = findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelUser user = sharedPreferences.getUser();
                String email = user.email;
                String password = user.password;
                userAuth(email, password);
            }
        });
    }

    public void userAuth(String email, String password) {
        String mail = emailLogin.getText().toString();
        String pass = passwordLogin.getText().toString();

        if (mail.equals(email) && pass.equals(password)) {
            Toast.makeText(this, "User Logged In", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User Not Valid", Toast.LENGTH_SHORT).show();
        }
    }
}
