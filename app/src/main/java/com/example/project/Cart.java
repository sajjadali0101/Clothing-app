package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Cart extends AppCompatActivity {

    EditText t1, Address, Qty,Card_number;

    RadioGroup Rg;
    RadioButton rb1, rb2;
    Button add_to_cart;

    ImageView Cart_image;

    TextView txt1, txt2;

    String Image, Descr, Rate;

String card_nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        add_to_cart = findViewById(R.id.add_cart);
        Rg = findViewById(R.id.radiogroup);

        Card_number=findViewById(R.id.Card_number);

        t1=findViewById(R.id.t1);

        Address=findViewById(R.id.adress_write);

        Qty=findViewById(R.id.Qty_write);

        t1.setText("1");



        Cart_image=findViewById(R.id.image_1);

        txt1=findViewById(R.id.descp_1);

        txt2=findViewById(R.id.price);

        rb1=findViewById(R.id.radiobtn_1);
        rb2=findViewById(R.id.radiobtn_2);

        Intent intent = getIntent();

       Image = intent.getStringExtra("image");

   Descr = intent.getStringExtra("description");

     Rate = intent.getStringExtra("rate");


        Glide.with(Cart_image).load(Image).into(Cart_image);


        txt1.setText(Descr);

        txt2.setText(Rate);



        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int id = Rg.getCheckedRadioButtonId();
                if (id == R.id.radiobtn_1) {

                    String address=Address.getText().toString();

                    String qty=Qty.getText().toString();

                    card_nu=Card_number.getText().toString();

                    Intent in=new Intent(Cart.this, Activity_mainfine.class);

                    in.putExtra("image", Image);

                    in.putExtra("address", address);

                    in.putExtra("card", card_nu);


                    in.putExtra("qty", qty);

                    in.putExtra("description", Descr);

                    in.putExtra("rate", Rate);

//                    new bgthread().start();
//
                    startActivity(in);




                } else if (id == R.id.radiobtn_2) {


                    Intent in=new Intent(Cart.this, information_form.class);

                    String address=Address.getText().toString();

                    String qty=Qty.getText().toString();

                    card_nu=Card_number.getText().toString();

                    in.putExtra("image", Image);

                    in.putExtra("address", address);

                    in.putExtra("card", card_nu);


                    in.putExtra("qty", qty);

                    in.putExtra("rate", Rate);

                    in.putExtra("description", Descr);

                    startActivity(in);

                }
                else{

                    Toast.makeText(Cart.this, "Please Select Stitched or UnStiched", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }



    }