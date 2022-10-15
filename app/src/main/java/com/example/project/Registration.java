package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText email, Password;
    Button CAccount_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
//        getSupportActionBar().hide();
        setContentView (R.layout.activity_registration);

        email = findViewById(R.id.Email);
        Password = findViewById(R.id.password);

        CAccount_btn = findViewById(R.id.CAccount);

        ProgressBar pb =  findViewById(R.id.loadingProgress);
        CAccount_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String Email = email.getText().toString();
                String password = Password.getText().toString();



                if(TextUtils.isEmpty(Email)) {
                    email.setError("E-mail is Required");
                    return;
                }
                else if(TextUtils.isEmpty(password)) {
                    Password.setError("Your message");
                    return;
                }

                pb.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email,password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult> () {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {

                                    pb.setVisibility(View.INVISIBLE);
                                    Toast.makeText(Registration.this,"Your Account is created Successfully.Please Login Now ",Toast.LENGTH_LONG).show();
                                    Snackbar.make(view,"Your Account is created Successfully",Snackbar.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(),Login.class));
                                }
                                else {
                                    pb.setVisibility(View.INVISIBLE);
                                    Snackbar.make(view,"Your account is not created",Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });


    }

    public void Login(View view) {
        startActivity(new Intent (getApplicationContext(),Login.class));
    }

}