package com.example.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public  class DatabaseHelper extends SQLiteOpenHelper {

    public  static final String DATABASE="Student.db";
    public static final String TABLE_NAME="student_table";

    public static final String col_1="ROLL_NO";

    public static final String col_2 = "AGE";

    public static final String col3="NAME";

    public DatabaseHelper(@Nullable Context context ) {
        super(context, DATABASE,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (ROLL_NO INTEGER PRIMARY KEY,NAME TEXT,AGE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean insertData(String roll,String name,String age){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,roll);
        contentValues.put(col_2,age);
        contentValues.put(col3,name);
     long  result =    sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
     return result!=-1;
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);


    }

    public void deleteData(String roll){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
         sqLiteDatabase.delete(TABLE_NAME,"ROLL_NO ="+roll,null);


    }
    public Boolean update(String roll,String name,String age){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,roll);
        contentValues.put(col_2,age);
        contentValues.put(col3,name);
        long  result =    sqLiteDatabase.update(TABLE_NAME,contentValues,"ROLL_NO=?",new  String[]{roll});
        return result!=-1;
    }

}