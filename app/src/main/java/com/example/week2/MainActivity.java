package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Variables for shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USERNAME = "username";
    public static final String ID = "id";

    private String mUsername;
    private String mPassword;

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    List<Users> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set title
        setTitle("Welcome");

        setUsers();

        wireDisplay();


    }

    //Create users for testing purposes
    private void setUsers() {
        Users user1 = new Users(1,"testuser1", "testuser1");
        Users user2 = new Users(2,"jupiter", "jupiter");
        Users user3 = new Users(3,"Marcus", "ilovesoda");

        mUsers = new ArrayList<>();

        mUsers.add(user1);
        mUsers.add(user2);
        mUsers.add(user3);
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

                for (Users user : mUsers) {
                    //Check if username is found in list of users
                    if (mUsername.equals(user.getUsername())) {
                        //Check if password is correct
                        if (mPassword.equals(user.getPassword())) {
                            //Set shared preferences
                            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putString(USERNAME, mUsername);
                            editor.putInt(ID, user.getUserId());
                            editor.apply();

                            //Go to landing page
                            Intent startIntent = LandingActivity.intentFactory(getApplicationContext(), user.getUserId());
                            startActivity(startIntent);
                        } else {
                            //If password not correct, highlight password field and display message
                            Toast.makeText(MainActivity.this, "Invalid Password. Please try again.", Toast.LENGTH_LONG).show();
                            passwordInput.requestFocus();
                            break;
                        }
                    }
                    //If username not found, highlight username field and display message
                    Toast.makeText(MainActivity.this, "Invalid Username. Please try again.", Toast.LENGTH_LONG).show();
                    usernameInput.requestFocus();
                    break;
                }

            }
        });
    }

    //Gets username and password from user input
    private void getValuesFromDisplay() {
        mUsername = usernameInput.getText().toString();
        mPassword = passwordInput.getText().toString();
    }

    public static Intent intentFactory(Context context) {
        return new Intent(context, MainActivity.class);
    }
}