package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    private RecyclerView recycler_view;
    private MyAdapter myAdapter;
    private ArrayList<Mountain> mountains;
    private Gson gson;
    private Type type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        mountains = new ArrayList<Mountain>();
        myAdapter = new MyAdapter(mountains);
        recycler_view.setAdapter(myAdapter);

        gson = new Gson();
        type = new TypeToken<ArrayList<Mountain>>() {}.getType();

        new JsonFile(this, this).execute(JSON_FILE);
        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        // Creating a new temporary list, We will fetch the json data and put it in there before updating the mountain list.
        ArrayList<Mountain> temp = new ArrayList <Mountain>();
        temp = gson.fromJson(json, type);
        // Clearing the current arraylist before adding the newly fetched one.
        mountains.clear();
        mountains.addAll(temp);
        myAdapter.notifyDataSetChanged();
    }

}
