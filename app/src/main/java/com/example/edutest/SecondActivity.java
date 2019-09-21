package com.example.edutest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray dataArray = obj.getJSONArray("data");
            for (int i = 0; i < 10; i++) {
                JSONObject dataDetail = dataArray.getJSONObject(i);
                id.add(dataDetail.getString("id"));
                name.add(dataDetail.getString("name"));
                email.add(dataDetail.getString("email"));
            }


        } catch (JSONException e) {
            e.printStackTrace();

        }

        list1Adapter ListAdapter = new list1Adapter(SecondActivity.this, id, name, email);
        recyclerView.setAdapter(ListAdapter);

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("list1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void ItemClick() {

        Intent ii = new Intent(this, ThirdActivity.class);
        startActivity(ii);

    }
}