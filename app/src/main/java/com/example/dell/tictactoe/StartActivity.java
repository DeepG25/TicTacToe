package com.example.dell.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    Button start,developer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        start = (Button)findViewById(R.id.start_btn);
        developer = (Button)findViewById(R.id.developer_btn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StartActivity.this,Option.class);
                startActivity(a);
            }
        });

        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartActivity.this,"Credits: Deep Godhani",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
