package com.example.sqliteapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editRoll, editName, editAge;
    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        editRoll = findViewById(R.id.et1);
        editName = findViewById(R.id.et2);
        editAge = findViewById(R.id.et3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3=  findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        // Example Insert Operation
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             boolean result = myDb.insertData(editRoll.getText().toString(), editName.getText().toString(), editAge.getText().toString());
             if (result) {
                 Toast.makeText(MainActivity.this, "Value Inserted Successfully :)", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(MainActivity.this, "Failed to insert the Vaalues to the DB(TvT)", Toast.LENGTH_SHORT).show();
             }
         }});



    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor cursor = myDb.getAllData();
            if(cursor.getCount()==0){
                Toast.makeText(MainActivity.this, "there is no record exisit", Toast.LENGTH_SHORT).show();

            }else{
                StringBuffer sb = new StringBuffer();
                while(cursor.moveToNext()){
                    sb.append("Roll_no"+cursor.getInt(0)+"\n");
                    sb.append("Name"+cursor.getInt(1)+'\n');
                    sb.append("Age"+cursor.getInt(2)+"\n");


                }
                showMessage("View Data",sb.toString());
            }


        }
    });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           boolean result =  myDb.update(editRoll.getText().toString(), editName.getText().toString(), editAge.getText().toString());
            if (result) {
                Toast.makeText(MainActivity.this, "Value Inserted Successfully :)", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Failed to insert the Vaalues to the DB(TvT)", Toast.LENGTH_SHORT).show();
            }
        }

    });

           b4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   myDb.deleteData(editRoll.getText().toString());
                   Toast.makeText(MainActivity.this, "done :)", Toast.LENGTH_SHORT).show();
               }
           });

    }
public void showMessage(String title,String message){
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(true);
        ab.setTitle(title);
        ab.setMessage(message);
        ab.show();
}
}