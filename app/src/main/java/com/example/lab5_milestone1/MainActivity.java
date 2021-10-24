package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(usernameKey, "").equals("")){
            String username = sharedPreferences.getString(usernameKey, "");
            goToActivity2(username);
        }
        else{
            setContentView(R.layout.activity_main);
        }
    }

    public void onClick(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username.getText().toString()).apply();
        goToActivity2(username.getText().toString());

    }
    public void goToActivity2(String username){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }


}