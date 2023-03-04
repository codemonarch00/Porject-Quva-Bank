package com.example.zoomnride;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class loginPage extends AppCompatActivity {
TextInputEditText password,email;
Button welcome;
TextView register;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);
        email = findViewById(R.id.LoginEmail);
        password = findViewById(R.id.LayoutPasswordField);
        welcome = findViewById(R.id.Welcome);
        register = findViewById(R.id.buttonRegister);

        register.setOnClickListener(view -> {
            Intent reg = new Intent(loginPage.this, MainActivity.class);

            startActivity(reg);
        });
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginPage.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Exit Application");
        alertDialog.setMessage("Are you sure you want to exit application");
        alertDialog.setCancelable(false);

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        AlertDialog dialog = alertDialog.create();
        dialog.show();


    }



}