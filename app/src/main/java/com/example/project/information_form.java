package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class information_form extends AppCompatActivity {

    EditText Age, Height, Brust, Waist, Shouler, Back, Sleeve;
    String Image, address, qty, Rate, Descr, card_nu, stitched_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_form);


        Age = findViewById(R.id.age);


        Height = findViewById(R.id.height);

        Brust = findViewById(R.id.bust);

        Waist = findViewById(R.id.waist);

        Shouler = findViewById(R.id.shoulder);

        Back = findViewById(R.id.back);

        Sleeve = findViewById(R.id.sleeve);


    }

    public void Add_to_Cart(View view) {
        String age = Age.getText().toString();

        String height = Height.getText().toString();
        String waist = Waist.getText().toString();
        String shoulder = Shouler.getText().toString();
        String back = Back.getText().toString();
        String sleeve = Sleeve.getText().toString();

        Intent intent = getIntent();

        Image = intent.getStringExtra("image");

        address = intent.getStringExtra("address");
        qty = intent.getStringExtra("qty");

        Rate = intent.getStringExtra("rate");

        Descr = intent.getStringExtra("description");

        card_nu = intent.getStringExtra("card");

        stitched_information = ("Age: " + age + " "+ "Height:"+ " " + height + " " + "Waist:" + " " + waist + " " + "Shoulder" + shoulder + " " + "Back" + " "
                + back + " " + "Sleeve" + sleeve);

        Intent in = new Intent(information_form.this, Activity_mainfine.class);

        in.putExtra("image", Image);

        in.putExtra("address", address);

        in.putExtra("card", card_nu);


        in.putExtra("qty", qty);

        in.putExtra("description", Descr);

        in.putExtra("rate", Rate);

        in.putExtra("stitch", stitched_information);
      startActivity(in);


    }
}