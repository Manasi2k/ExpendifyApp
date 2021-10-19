package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flatdialoglibrary.dialog.FlatDialog;

public class Budget extends AppCompatActivity {
    Button Butaddbudget;
    Button Btnviewremaining;
    EditText etamt;
    float remaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        setTitle("Budget");
    }
    public void addbudget(View view)
    {
        Butaddbudget=findViewById(R.id.butaddbudget);
        Btnviewremaining=findViewById(R.id.butviewbudget);
        etamt=findViewById(R.id.txtbudget);
//        SharedPreferences sharedPreferences=getSharedPreferences("Expendify",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
        float budgetAmt=Float.parseFloat(etamt.getText().toString());

//        editor.putFloat("Budget",budgetAmt);
//        float expense=sharedPreferences.getFloat("Total_Expenses",0.0f);
//        float budget=sharedPreferences.getFloat("Budget",0.0f);
//        remaining=budget-expense;
//        editor.apply();

        db_budget bgt=new db_budget();
        bgt.setAmount(budgetAmt);
        DBhelper db=new DBhelper(this);
        db.addbudget(bgt);
        Toast.makeText(this,"Budget Recorded Successfully!",Toast.LENGTH_LONG).show();

    }
    public void viewremaining(View view) {
        DBhelper db=new DBhelper(this);
        float expense=db.getTotalExpenses();
        float budget=db.getTotalBudget();
        remaining=budget-expense;

        final FlatDialog flatDialog = new FlatDialog(this);
        flatDialog.setTitle("View Remaining")
                .setSubtitle("Remaining amount Rs." + remaining + "/-")
                .setFirstButtonText("OK")
                .setSecondButtonText("Cancel")
                .withFirstButtonListner(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), flatDialog.getFirstTextField(),
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .withSecondButtonListner(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        flatDialog.dismiss();
                    }
                })
                .show();
    }

    public void gohome(View view)
    {
        Intent MainActivity= new Intent(this,MainActivity.class);
        startActivity(MainActivity);
    }
}