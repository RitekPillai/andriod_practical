package com.example.formapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText et1,et2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et1.getText().toString();

                String password = et2.getText().toString();
                Intent intent = new Intent(MainActivity.this, SucessPage.class);
                if(name.equals("ritek") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Login SucessFull", Toast.LENGTH_SHORT).show();
                    intent.putExtra("username",name);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Invaild input:"+password+name, Toast.LENGTH_SHORT).show();
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}