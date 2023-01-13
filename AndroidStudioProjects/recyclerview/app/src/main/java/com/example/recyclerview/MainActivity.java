package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{
    RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayItems();
    }

    private void displayItems() {
        recyclerView= findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myModelList = new ArrayList<>();
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("Jihadul",25));
        myModelList.add(new MyModel("Aihadul",25));
        myModelList.add(new MyModel("Bihadul",25));
        myModelList.add(new MyModel("Cihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("Jihadul",25));
        myModelList.add(new MyModel("Aihadul",25));
        myModelList.add(new MyModel("Bihadul",25));
        myModelList.add(new MyModel("Cihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("Jihadul",25));
        myModelList.add(new MyModel("Aihadul",25));
        myModelList.add(new MyModel("Bihadul",25));
        myModelList.add(new MyModel("Cihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("Jihadul",25));
        myModelList.add(new MyModel("Aihadul",25));
        myModelList.add(new MyModel("Bihadul",25));
        myModelList.add(new MyModel("Cihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        myModelList.add(new MyModel("zihadul",25));
        customAdapter = new CustomAdapter(this,myModelList,this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onItemClicked(MyModel myModel) {
        Toast.makeText(this, myModel.getName(), Toast.LENGTH_SHORT).show();
    }
}