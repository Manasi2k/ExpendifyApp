package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        setTitle("Analysis");

        SharedPreferences preferences=getSharedPreferences("Expendify",MODE_PRIVATE);
        TextView txtanalysis=findViewById(R.id.txtanalysis);
        DBhelper db=new DBhelper(this);
        String x=String.valueOf((db.viewAnalysis()));

//
//        String Category=preferences.getString("itemcategory",null);
//        float amount=preferences.getFloat("itemamount",0.0f);s
        txtanalysis.setText(x);
    }
    public void gohome(View view)
    {
        Intent MainActivity= new Intent(this,MainActivity.class);
        startActivity(MainActivity);
        finish();
    }
}