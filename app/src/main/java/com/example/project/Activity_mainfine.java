package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.Database.AppDatabase;
import com.example.project.Model.Product;
import com.example.project.Model.ProductDao;

public class Activity_mainfine extends AppCompatActivity {

    EditText t1,t2,t3,t4;
    Button b1,b2;
    TextView lbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfine);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        b1=findViewById(R.id.b1);


        Intent intent = getIntent();

       String Image = intent.getStringExtra("image");

        String Address = intent.getStringExtra("address");

        String qty= intent.getStringExtra("qty");

        String Rate= intent.getStringExtra("rate");

        String descr= intent.getStringExtra("description");

        String card_num=intent.getStringExtra("card");

        String stitch=intent.getStringExtra("stitch");

        t3.setText(Rate);

        t2.setText("Suit Description: "+ " "+descr+"."+"\n" + "Address:" +Address+ "\n "+ "\n "+stitch);

        t4.setText(qty);

   t1.setText(card_num);


              AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_db").allowMainThreadQueries()
                      .fallbackToDestructiveMigration().build();
                ProductDao productDao=db.ProductDao();

                int num=productDao.is_exist(Integer.parseInt(t1.getText().toString()));
                if(num!=0){
                    Toast.makeText(this, "enter another card id", Toast.LENGTH_SHORT).show();

                } else{
//                Boolean check=productDao.is_exist(Integer.parseInt(t1.getText().toString()));
//                if(check==false)
//                {
                    int pid=Integer.parseInt(t1.getText().toString());

        String pname=t2.getText().toString();

        int price=Integer.parseInt(t3.getText().toString());

        int qnt=Integer.parseInt(t4.getText().toString());

                    productDao.insertrecord(new Product(pid,pname,price,qnt,Image));

                    t1.setText("");

                    t2.setText("");

                    t3.setText("");

                    t4.setText("");
//                    lbl.setText("Product Inserted Successfully");
//                }
//                else
//                {
//                    t1.setText("");
//                    t2.setText("");
//                    t3.setText("");
//                    t4.setText("");
//                    lbl.setText("Product Already in Cart");
                }
        startActivity(new Intent(this,cartdata.class));
finish();
            }


    }
