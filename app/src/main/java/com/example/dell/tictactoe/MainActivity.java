package com.example.dell.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e1;
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.start);
        e1=(EditText)findViewById(R.id.firstplayer);
        e2=(EditText)findViewById(R.id.secondplayer);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("first",s1);
                i.putExtra("second",s2);
                startActivity(i);
            }
        });


    }
}
