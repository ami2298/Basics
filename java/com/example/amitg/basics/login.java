package com.example.amitg.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClickButton(View v){

        if(v.getId()==R.id.login){
            EditText a=(EditText)findViewById(R.id.luname);
            String str = a.getText().toString();
            EditText b=(EditText)findViewById(R.id.lupass);
            String pass = b.getText().toString();

            String password= helper.searchPass(str);
            if(pass.equals(password)) {
                Intent i = new Intent(login.this, welcome.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
            else {
                Toast.makeText(login.this, "Username and Password is not matched", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
