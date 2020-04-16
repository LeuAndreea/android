package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Greyson", "Chance", "bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        people = new ArrayList<Person>();
        people.add(new Person("Tyler ","Joseph", "bus"));
        people.add(new Person("Josh", "Dunn", "bus"));
        people.add(new Person ("Tom", "Holland","plane"));
        people.add(new Person ("Peter", "Parker","plane"));
        people.add(new Person("Tyler ","Joseph", "bus"));
        people.add(new Person("Josh", "Dunn", "bus"));
        people.add(new Person ("Tom", "Holland","plane"));
        people.add(new Person ("Peter", "Parker","plane"));
        people.add(new Person("Tyler ","Joseph", "bus"));
        people.add(new Person("Josh", "Dunn", "bus"));
        people.add(new Person ("Tom", "Holland","plane"));
        people.add(new Person ("Peter", "Parker","plane"));
        people.add(new Person("Tyler ","Joseph", "bus"));
        people.add(new Person("Josh", "Dunn", "bus"));
        people.add(new Person ("Tom", "Holland","plane"));
        people.add(new Person ("Peter", "Parker","plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();

    }
}
