package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.Fragment.Home_page_fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Button Login;

    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.password);

        Login=findViewById(R.id.b1);


        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // show the visibility of progress bar to show loading

                // Take the value of two edit texts in Strings
                String email, password;
                email = Email.getText().toString();
                password =Password.getText().toString();

                // validations for input email and password
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                            .show();

                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                // signin existing user
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(
                                            @NonNull Task<AuthResult> task)
                                    {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(),
                                                    "Login successful!!",
                                                    Toast.LENGTH_LONG)
                                                    .show();

                                            // hide the progress bar


                                            // if sign-in is successful
                                            // intent to home activity
                                            Intent intent
                                                    = new Intent(Login.this,
                                                    myActivity.class);
                                            startActivity(intent);

                                            finish();
                                        }

                                        else {

                                            // sign-in failed
                                            Toast.makeText(getApplicationContext(),
                                                    "Login failed!!",
                                                    Toast.LENGTH_LONG)
                                                    .show();

                                            // hide the progress bar
                                        }
                                    }
                                });

            }
        });


    }

    public void Register(View view) {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }

    public void Press(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Home_page_fragment()).commit();

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
}