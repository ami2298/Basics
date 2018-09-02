package com.example.amitg.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void onSign(View v){
        if(v.getId()==R.id.Signin){
            EditText name=(EditText)findViewById(R.id.name);
            EditText email=(EditText)findViewById(R.id.email);
            EditText uname=(EditText)findViewById(R.id.uname);
            EditText pass=(EditText)findViewById(R.id.pass);
            EditText cpass=(EditText)findViewById(R.id.confirmpass);

            String namestr= name.getText().toString();
            String emailstr= email.getText().toString();
            String unamestr= uname.getText().toString();
            String passstr= pass.getText().toString();
            String cpassstr=cpass.getText().toString();

            if(!passstr.equals(cpassstr)){
                Toast.makeText(this, "Password don't match ", Toast.LENGTH_SHORT).show();
            }
            else {
                Contact c= new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(passstr);

                helper.onInsert(c);
                Toast.makeText(signup.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(signup.this,login.class);
                startActivity(i);

            }



        }
    }
}
