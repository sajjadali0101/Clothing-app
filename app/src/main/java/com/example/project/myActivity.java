package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class myActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void press(View view) {
        Intent in=new  Intent(this, Cloth_list.class);

        String Male="Male";
  in.putExtra("recycler", Male);
  startActivity(in);
    }

    public void Female(View view) {
        Intent in=new  Intent(this, Cloth_list.class);

        String female="Female";
        in.putExtra("recycler", female);
        startActivity(in);
    }
}