package com.example.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


final static int camera = 100,contact=101,calendar=102,storage= 103;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.b1).setOnClickListener(view -> checkpermission(Manifest.permission.READ_CONTACTS,camera) );
        findViewById(R.id.b2).setOnClickListener(view -> checkpermission(Manifest.permission.READ_CALENDAR,contact));
        findViewById(R.id.b3).setOnClickListener(v -> checkpermission(Manifest.permission.CAMERA, calendar));
        findViewById(R.id.b4).setOnClickListener(v -> checkpermission(Manifest.permission.READ_EXTERNAL_STORAGE, storage));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void checkpermission(String perm,int reqCode) {
        if (ContextCompat.checkSelfPermission(this, perm) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{perm}, reqCode);

        } else {
            Toast.makeText(this, "Permission ALready granted", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean granted = (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
        String status =  granted ? "Granted" : "Deny";
        switch (requestCode){
            case camera:
                Toast.makeText(this, "Carmera Permission"+status, Toast.LENGTH_SHORT).show();
            case contact:
                Toast.makeText(this, "Contact permission"+status, Toast.LENGTH_SHORT).show();
            case calendar:
                Toast.makeText(this, "Calendar permission"+status, Toast.LENGTH_SHORT).show();
            case storage:
                Toast.makeText(this, "Storage permission"+status, Toast.LENGTH_SHORT).show();
        }

    }
}
