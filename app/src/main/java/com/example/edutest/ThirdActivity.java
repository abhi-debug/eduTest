package com.example.edutest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    RecyclerView recyclerView2;
    ArrayList<String> date=new ArrayList<>();
    ArrayList<String> amnt=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView2=findViewById(R.id.recycler_view2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(linearLayoutManager);

try
{
    JSONObject obj=new JSONObject(loadJSONFromAsset());
    JSONArray userArray = obj.getJSONArray("data");
    // implement for loop for getting users list data
    for (int i = 0; i < 10; i++) {
        // create a JSONObject for fetching single user data
        JSONObject userDetail = userArray.getJSONObject(i);
        // fetch email and name and store it in arraylist
        date.add(userDetail.getString("date_created"));
        amnt.add(userDetail.getString("amount"));
        // create a object for getting contact data from JSONObject

    }
}catch (JSONException e){ e.printStackTrace();}

list2Adapter list2Adapter=new list2Adapter(ThirdActivity.this,date,amnt);
recyclerView2.setAdapter(list2Adapter);

       }

    private String loadJSONFromAsset() {
        String json=null;
       try{
           InputStream is=getAssets().open("list2.json");
            int size = is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();

           json = new String(buffer, "UTF-8");

       }catch(IOException e){e.printStackTrace();}

return json;
    }


}
