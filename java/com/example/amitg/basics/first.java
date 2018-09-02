package com.example.amitg.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
     public void onButton(View v){
         if(v.getId()==R.id.logo){
             Intent i= new Intent(first.this, second.class);
             startActivity(i);
         }

     }
}
