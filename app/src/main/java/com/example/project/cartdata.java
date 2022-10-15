package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.Adapter.myadapter;
import com.example.project.Database.AppDatabase;
import com.example.project.Model.Product;
import com.example.project.Model.ProductDao;

import java.util.List;

public class cartdata extends AppCompatActivity {



    RecyclerView recview;
    TextView rateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdata);

        rateview=findViewById(R.id.rateview);
        getroomdata();
    }

    public void getroomdata()
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cart_db").allowMainThreadQueries().build();
        ProductDao productDao = db.ProductDao();


        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products=productDao.getallproduct();

        myadapter adapter=new myadapter(products, rateview);
        recview.setAdapter(adapter);

        int sum=0,i;

        for(i=0;i< products.size();i++)

            sum=sum+(products.get(i).getPrice()*products.get(i).getQnt());

        rateview.setText("Total Amount : Pkr "+sum);
    }
    public void  onBackPress(){


    }

}