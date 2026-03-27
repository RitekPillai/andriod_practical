package com.example.lifecycle;

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
    TextView tv;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LC","onDestory");
        Toast.makeText(this, "onDestory Invoked ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LC","onPause");
        Toast.makeText(this, "onPause Invoked ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LC","OnRestart");
        Toast.makeText(this, "OnRestart Invoked ", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LC","OnStart");
        Toast.makeText(this, "OnStart Invoked ", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LC","OnResume");
        Toast.makeText(this, "OnResume Invoked ", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d("LC","OnStop");
        Toast.makeText(this, "OnStop Invoked ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        tv=findViewById(R.id.tv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello world");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}