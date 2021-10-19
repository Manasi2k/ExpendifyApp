package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Report extends AppCompatActivity {
    TextView txtreport;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        setTitle("Reports");
        DBhelper db=new DBhelper(this);
        float total_expenses=db.getTotalExpenses();
        float total_budget=db.getTotalBudget();


        SharedPreferences sharedPreferences=getSharedPreferences("Expendify",MODE_PRIVATE);
        txtreport=findViewById(R.id.txtreport);
//        float Total_Expenses=sharedPreferences.getFloat("Total_Expenses",0.0f);
//       float budget=sharedPreferences.getFloat("Budget",0.0f);
       float remaining=total_budget-total_expenses;
       txtreport.setText("Total_Expenses :"+total_expenses);
        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);


        mPieChart.addPieSlice(new PieModel("Total_Expenses",total_expenses, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Remaining", remaining, Color.parseColor("#56B7F1")));


        mPieChart.startAnimation();


    }
    public void gohome(View view)
    {
        Intent MainActivity= new Intent(this,MainActivity.class);
        startActivity(MainActivity);
        finish();
    }
}