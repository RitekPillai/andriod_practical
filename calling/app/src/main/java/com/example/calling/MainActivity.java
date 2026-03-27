package com.example.calling;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        et1=findViewById(R.id.et1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                if(et1.getText().toString().length() == 10){
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);
                        return;
                    }
                    intent.setData(Uri.parse("tel:"+et1.getText().toString()));
                    Toast.makeText(MainActivity.this, "Calling to "+et1.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Enter Valid Number", Toast.LENGTH_SHORT).show();
                }


            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(this, "Permision Granted", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "Permission Denyied ", Toast.LENGTH_SHORT).show();
//        }
//        return;
//    }
}