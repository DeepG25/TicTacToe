package com.example.dell.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Option extends AppCompatActivity {

    Button human,computer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        human = (Button)findViewById(R.id.human_btn);
        computer = (Button)findViewById(R.id.computer_btn);

        human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ai = new Intent(Option.this,MainActivity.class);
                startActivity(ai);
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ai = new Intent(Option.this,Main3Activity.class);
                startActivity(ai);
            }
        });
    }
}
