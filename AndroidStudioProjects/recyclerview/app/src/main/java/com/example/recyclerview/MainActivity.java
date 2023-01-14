package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{
    RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;
    SearchView searchView;
    LinearLayout linearLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.search_view);
        linearLayout = findViewById(R.id.linear_layout);
        displayItems();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    private void filter(String newText) {
        List<MyModel> filteredList = new ArrayList<>();
        for(MyModel item : myModelList){
            if(item.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        customAdapter.filterlist(filteredList);
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


    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Snackbar snackbar = Snackbar.make(linearLayout,"Item Deleted",Snackbar.LENGTH_LONG);
            snackbar.show();

            myModelList.remove(viewHolder.getAdapterPosition());
            customAdapter.notifyDataSetChanged();
        }
    };
}