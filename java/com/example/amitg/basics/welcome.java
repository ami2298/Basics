package com.example.amitg.basics;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class welcome extends AppCompatActivity {
     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String Username = getIntent().getStringExtra("Username");
        TextView tv =(TextView)findViewById(R.id.tvusername);
        tv.setText(Username);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Introduction",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String string;
                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
                if(itemPosition==0){
                    Intent i=new Intent(welcome.this,content.class);

                    startActivity(i);
                }
                else if(itemPosition==1){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==2){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==3){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==4){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==5){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==6){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }
                else if(itemPosition==7){
                    Intent i=new Intent(welcome.this,content.class);
                    startActivity(i);
                }


            }

        });
    }
    public void onLogout(View v){
        Intent i = new Intent(welcome.this,first.class);
        startActivity(i);


    }
}
