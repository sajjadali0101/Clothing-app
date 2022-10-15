package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.project.Database.AppDatabase;
import com.example.project.Model.Product;
import com.example.project.Model.ProductDao;

public class Activity extends AppCompatActivity
{
   EditText t1,t2,t3,t4;
   Button b1,b2;
   TextView lbl;

    public Activity(Cart cart, Class<cartdata> cartdataClass) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

        b1=findViewById(R.id.b1);
        lbl=findViewById(R.id.lbl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"cart_db").allowMainThreadQueries()
                      .fallbackToDestructiveMigration().build();
              ProductDao productDao=db.ProductDao();

               int check=productDao.is_exist(Integer.parseInt(t1.getText().toString()));
               if(check==0)
               {



                  int pid=Integer.parseInt(t1.getText().toString());
                  String pname=t2.getText().toString();
                  int price=Integer.parseInt(t3.getText().toString());
                  int qnt=Integer.parseInt(t4.getText().toString());
                  productDao.insertrecord(new Product(pid,pname,price,qnt,""));
                  t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");
                  lbl.setText("Product Inserted Successfully");
               }
               else
               {
                   t1.setText("");
                   t2.setText("");
                   t3.setText("");
                   t4.setText("");
                   lbl.setText("Product Already in Cart");
               }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),cartdata.class));

            }
        });
    }
}