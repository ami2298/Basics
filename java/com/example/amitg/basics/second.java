package com.example.amitg.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClickButton(View v){
        if(v.getId()==R.id.signup){
            Intent i= new Intent(second.this, signup.class);
            startActivity(i);
        }
        if(v.getId()==R.id.login){
            Intent i= new Intent(second.this, login.class);
            startActivity(i);
        }
    }
}
