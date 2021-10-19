package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddExpense extends AppCompatActivity {
    EditText entitle;
    EditText ecategory;
    EditText ecomment;
    EditText eamount;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        setTitle("Add Expense");
        entitle=(EditText) findViewById(R.id.txtexpitm);
        ecomment=(EditText) findViewById(R.id.txtexpcomment);
        eamount=(EditText) findViewById(R.id.txtexpamt);
        spinner1=findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void gohome(View view)
    {
        Intent MainActivity= new Intent(this,MainActivity.class);
        startActivity(MainActivity);
    }
    public void AddExpenses(View view)
    {
//        SharedPreferences sharedPreferences=getSharedPreferences( "Expendify",MODE_PRIVATE);
//        SharedPreferences.Editor editor= sharedPreferences.edit();
        String itemName,itemcategory,itemcomment;
        float itemamount,totalamount=0.0f;


        itemName=entitle.getText().toString();
        itemcategory=String.valueOf(spinner1.getSelectedItem());
        itemcomment=ecomment.getText().toString();
        itemamount=Float.parseFloat(eamount.getText().toString());

        db_expenses exp=new db_expenses();
        exp.setTitle(itemName);
        exp.setCategory(itemcategory);
        exp.setComment(itemcomment);
        exp.setAmount(itemamount);
        DBhelper db=new DBhelper(this);
        db.addExpense(exp);
        Toast.makeText(this,"Expense Recorded Successfully!",Toast.LENGTH_LONG).show();


//        editor.putString("itemname",itemName);
//        editor.putString("itemcategory",itemcategory);
//        editor.putString("itemcomment",itemcomment);
//        editor.putFloat("itemamount",itemamount);
//
//        if (sharedPreferences.contains("Total_Expenses"))
//        {
//            totalamount=sharedPreferences.getFloat("Total_Expenses",0.0f);
//            totalamount=totalamount+totalamount;
//            editor.putFloat("Total_Expenses",totalamount);
//        }
//        else
//            editor.putFloat("Total_Expenses",itemamount);
//
//        Toast.makeText(this,sharedPreferences.getString ("itemname",null)+ "\n"
//                + sharedPreferences.getString("itemctegory",null)+ "\n"+sharedPreferences.getString("itemcomment",null)+ "\n"
//                        +sharedPreferences.getFloat("itemamount",0.0f)+ "\n"
//                        +sharedPreferences.getFloat("Total_Expenses",0.0f),Toast.LENGTH_SHORT).show();
//
//
//        editor.apply();

    }
}