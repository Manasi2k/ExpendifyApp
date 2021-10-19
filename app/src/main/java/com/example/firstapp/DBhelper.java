package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper  {
    public DBhelper(Context context)
    {
        super(context,"db_Expendify",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String tbl_expenses=
                "CREATE TABLE \"tbl_expenses\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"Title\"\tTEXT NOT NULL,\n" +
                "\t\"Comment\"\tTEXT NOT NULL,\n" +
                "\t\"Category\"\tREAL NOT NULL,\n" +
                        "\t\"Amount\"\tREAL NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        String tbl_budget=

               "CREATE TABLE \"tbl_budget\" (\n" +
                       "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                       "\t\"Amount\"\tREAL NOT NULL,\n" +
                       "\tPRIMARY KEY(\"id\"AUTOINCREMENT)\n" +
                       ");\n";
        db.execSQL(tbl_expenses);
        db.execSQL(tbl_budget);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
    public void  addExpense(db_expenses expense)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Title",expense.getTitle());
        values.put("Category",expense.getCategory());
        values.put("Comment",expense.getComment());
        values.put("Amount",expense.getAmount());
        db.insert("tbl_expenses",null,values);
        db.close();

    }
    public void  addbudget(db_budget budget)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Amount",budget.getAmount());
        db.insert("tbl_budget",null,values);
        db.close();

    }
    public float getTotalExpenses()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select SUM(Amount) as expenses from tbl_expenses;",null);
        if (c.moveToFirst())
        {
            return Float.parseFloat(c.getString(0));
        }
        c.close();
        return 0;
    }
    public float getTotalBudget()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select SUM(Amount) as budget from tbl_budget;",null);
        if(c.moveToFirst())
        {
        // c.close();
            return Float.parseFloat(c.getString(0));
        }
        c.close();
return 0;
    }

    public  String viewAnalysis()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.rawQuery("select Amount,Category from tbl_expenses",null);
    if(c.moveToLast())
    {
        float amount=Float.parseFloat(c.getString(0));
        String category=c.getString(1);
        String abc=category+": "+amount+"";
        return abc;
    }
    c.close();
    return  null;
    }

}
