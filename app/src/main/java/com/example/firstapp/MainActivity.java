package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addExpense(View view)
    {
        Intent expense= new Intent(this,AddExpense.class);
        startActivity(expense);
    }
    public void viewReport(View view)
    {
        Intent report= new Intent(this,Report.class);
        startActivity(report);
    }
    public void addbudget(View view)
    {
        Intent budget= new Intent(this,Budget.class);
        startActivity(budget);
    }
    public void seeAnalysis(View view)
    {
        Intent analysis= new Intent(this,Analysis.class);
        startActivity(analysis);
    }
    public void bootstrap(View view)
    {
        Toast.makeText(this, "This is my FIRST APP", Toast.LENGTH_SHORT).show();
    }


}