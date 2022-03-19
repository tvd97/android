package com.example.docbao.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.*;
import com.example.docbao.Adapter.adapterStr;
import com.example.docbao.ClassModel.Story;
import com.example.docbao.ClassModel.server;
import com.example.docbao.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    Context context= this;
    RecyclerView recyclerView;
    EditText edt;
    Button btn;
    adapterStr str;
    ArrayList<Story> list;
    int id=0;
    String name="";
    String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        edt=(EditText) findViewById(R.id.txtSeach);

        btn=(Button) findViewById(R.id.btnseach);
        //getData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,ChapterActivity.class);
                startActivity(intent);

            }
        });


    }
//    private  void getData()
//    {
//        RequestQueue requestQueue= Volley.newRequestQueue(context);
//        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(server.url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if(response!=null)
//                {
//
//                    for (int i=0;i<response.length();i++)
//                    {
//                        try {
//                            JSONObject jsonObject= response.getJSONObject(i);
//
//                            id=(int) jsonObject.getInt("idStory");
//                            name= jsonObject.getString("nameStory");
//                            type= jsonObject.getString("typeStory");
//                            Log.e("6",id+"");
//                            Story item= new Story(id,name,type);
//                            list.add(item);
//                            Log.e("loi o day",item.nameStory+"");
//                            str= new adapterStr(context,list);
//                            str.notifyDataSetChanged();
//                            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                            recyclerView.setAdapter(str);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(jsonArrayRequest);
//    }
    }
