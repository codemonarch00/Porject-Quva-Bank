package com.example.zoomnride;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinner, spinnerState;
    @SuppressWarnings("rawtypes")
    ArrayAdapter adapter, state, ghana;
    EditText phone,email,password,confirmPassword,name;
    TextView code, passwordAlert, confirmPasswordAlert;
    String countryOption,stateOption;
    Button register, login;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        spinnerState = findViewById(R.id.spinnerState);
        spinner = findViewById(R.id.spinnerCountry);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.UserEmailAddress);
        name = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        confirmPasswordAlert = findViewById(R.id.confirmPasswordAlert);
        passwordAlert = findViewById(R.id.passwordAlert);
        confirmPassword = findViewById(R.id.confirmPassword);
        code = findViewById(R.id.countryCode);
        register = findViewById(R.id.signUp);
        login = findViewById(R.id.btnLogin);


        ghana = ArrayAdapter.createFromResource(this,R.array.ghana, android.R.layout.simple_spinner_dropdown_item);
        ghana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state = ArrayAdapter.createFromResource(this,R.array.Nigeria, android.R.layout.simple_spinner_dropdown_item);
        state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter = ArrayAdapter.createFromResource(this,R.array.spinnerList, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        //onclick spinner List methods
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            countryOption= adapterView.getItemAtPosition(i).toString();
                if (i == 0){
                 spinnerState.setAdapter(null);
                 code.setText(null);
                 phone.setEnabled(false);
                }
              else if (i == 1){
                  spinnerState.setAdapter(state);
                  code.setText(R.string.nigeriaCode);
                    phone.setEnabled(true);
              }

              else if (i == 2) {
                  spinnerState.setAdapter(ghana);
                  code.setText(R.string.ghanaCode);
                    phone.setEnabled(true);
              }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
       spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               stateOption = adapterView.getItemAtPosition(i).toString();

           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

       register.setOnClickListener(view -> {

       });

       login.setOnClickListener(view -> {
           Intent loginActivity = new Intent(MainActivity.this,loginPage.class);

           startActivity(loginActivity);
       });
    }


}