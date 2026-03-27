package com.example.submenuapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
        Toast.makeText(this, "You Selected "+item.getTitle(), Toast.LENGTH_SHORT).show();

        if(id == R.id.sm1){
           relativeLayout.setBackgroundColor(Color.BLUE);
       }
       if(id==R.id.sm2){
           relativeLayout.setBackgroundColor(Color.RED);
       }
       if(id==R.id.sm3){
           relativeLayout.setBackgroundColor(Color.GREEN);
       }
       if(id==R.id.sm4){
           relativeLayout.setBackgroundColor(Color.YELLOW);
       }
        return super.onOptionsItemSelected(item);
    }
}