package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String mUsername;
    private String mPassword;

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set title
        setTitle("Welcome");

        setUsers();

        wireDisplay();


        //Check if username and password are valid


    }

    //Create users for testing purposes
    private void setUsers() {
        Users user1 = new Users(1,"testuser1", "testuser1");
        Users user2 = new Users(2,"jupiter", "jupiter");
        Users user3 = new Users(3,"Marcus", "ilovesoda");
    }

    private void wireDisplay() {
        //Find username and password fields
        usernameInput = findViewById(R.id.edit_text_username);
        passwordInput = findViewById(R.id.edit_text_password);

        //Start the landing activity when login is clicked and username and password are validated
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();



                Intent startIntent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(startIntent);
            }
        });
    }

    //Gets username and password from user input
    private void getValuesFromDisplay() {
        mUsername = usernameInput.getText().toString();
        mPassword = passwordInput.getText().toString();
    }
}