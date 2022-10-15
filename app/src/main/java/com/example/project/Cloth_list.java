package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project.Adapter.Menu_for_list;
import com.example.project.Model.Menu_list;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cloth_list extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Menu_list> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_list);

        recyclerView=findViewById(R.id.recycler1);
        Intent intent = getIntent();

        String titlegot = intent.getStringExtra("recycler");


        DatabaseReference database= FirebaseDatabase.getInstance().getReference(titlegot);

        Menu_for_list adapter = new Menu_for_list(list, Cloth_list.this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(Cloth_list.this);
        recyclerView.setLayoutManager(layoutManager);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Menu_list buses = dataSnapshot.getValue(Menu_list.class);
                    buses.getBusId(dataSnapshot.getKey());
                    list.add(buses);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

    public void Button(View view) {
        startActivity(new Intent(Cloth_list.this, cartdata.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
//        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
//        adapter.stopListening();
    }

}