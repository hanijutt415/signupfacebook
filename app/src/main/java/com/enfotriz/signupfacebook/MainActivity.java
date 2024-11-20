package com.enfotriz.signupfacebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText numberEditText;
    EditText emailEditText;
    EditText passwordEditText;
    Button signupbtn;

    SharedPreferences sharedPreferences;
    public Sharedpref sharedpref; // Assuming this is your custom class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize sharedPreferences properly
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.apply();

        // Initialize views
        nameEditText = findViewById(R.id.name);
        numberEditText = findViewById(R.id.number);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        signupbtn = findViewById(R.id.signup);

        // Initialize your Sharedpref object
        sharedpref = new Sharedpref(this); // Assuming Sharedpref is a wrapper around SharedPreferences

        // Set onClick listener for signup button
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user input
                String name = nameEditText.getText().toString();
                String number = numberEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Create a model object
                ModelUser obj = new ModelUser(name, number, email, password);

                // Save the user data using the Sharedpref class
                sharedpref.saveUser(obj);

                // Display a success message
                Toast.makeText(MainActivity.this, "User saved successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
