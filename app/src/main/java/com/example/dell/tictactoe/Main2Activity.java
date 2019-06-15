package com.example.dell.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class Main2Activity extends AppCompatActivity {

    Button R1C1,R1C2,R1C3,R2C1,R2C2,R2C3,R3C1,R3C2,R3C3,reset;
    TextView textview,text_player1,text_player2;
    int count=0;
    int c1,c2,c3,c4,c5,c6,c7,c8,c9,ct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        final String s1 = i.getStringExtra("first");
        final String s2 = i.getStringExtra("second");

        R1C1=(Button)findViewById(R.id.button11);
        R1C2=(Button)findViewById(R.id.button12);
        R1C3=(Button)findViewById(R.id.button13);
        R2C1=(Button)findViewById(R.id.button21);
        R2C2=(Button)findViewById(R.id.button22);
        R2C3=(Button)findViewById(R.id.button23);
        R3C1=(Button)findViewById(R.id.button31);
        R3C2=(Button)findViewById(R.id.button32);
        R3C3=(Button)findViewById(R.id.button33);
        reset=(Button)findViewById(R.id.reset);
        textview=(TextView)findViewById(R.id.textview);
        text_player1=(TextView)findViewById(R.id.text_player1);
        text_player2=(TextView)findViewById(R.id.text_player2);

        text_player1.setText("Player 1 :" + s1);
        text_player2.setText("Player 2 :" + s2);

        R1C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ct==0) {count++;
                    if(count%2 == 0)
                    {
                        R1C1.setText("O");
                        c1=-1;
                        if(c1+c2+c3 == -3 || c1+c4+c7 == -3 ||c1+c5+c9 == -3)
                        {
                            textview.setText("Winner is " + s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R1C1.setText("X");
                        c1=1;
                        if(c1+c2+c3 == 3 || c1+c4+c7 == 3 ||c1+c5+c9 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R1C1.setEnabled(FALSE);}
            }
        });

        R1C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R1C2.setText("O");
                        c2=-1;
                        if(c1+c2+c3 == -3 || c2+c5+c8 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R1C2.setText("X");
                        c2=1;
                        if(c1+c2+c3 == 3 || c2+c5+c8 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R1C2.setEnabled(FALSE);}
            }
        });

        R1C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R1C3.setText("O");
                        c3=-1;
                        if(c1+c2+c3 == -3 || c3+c6+c9 == -3 ||c3+c5+c7 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R1C3.setText("X");
                        c3=1;
                        if(c1+c2+c3 == 3 || c3+c6+c9 == 3 || c3+c5+c7 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R1C3.setEnabled(FALSE);}
            }
        });

        R2C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R2C1.setText("O");
                        c4=-1;
                        if(c1+c4+c7 == -3 || c4+c5+c6 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R2C1.setText("X");
                        c4=1;
                        if(c1+c4+c7 == 3 || c4+c5+c6 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R2C1.setEnabled(FALSE);}
            }
        });

        R2C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R2C2.setText("O");
                        c5=-1;
                        if(c1+c5+c9 == -3 || c2+c5+c8 == -3 ||c4+c5+c6 == -3 || c3+c5+c7 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R2C2.setText("X");
                        c5=1;
                        if(c1+c5+c9 == 3 || c2+c5+c8 == 3 ||c4+c5+c6 == 3 || c3+c5+c7 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R2C2.setEnabled(FALSE);}
            }
        });

        R2C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R2C3.setText("O");
                        c6=-1;
                        if(c6+c3+c9 == -3 || c4+c5+c6 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R2C3.setText("X");
                        c6=1;
                        if(c6+c3+c9 == 3 || c4+c5+c6 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R2C3.setEnabled(FALSE);}
            }
        });

        R3C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R3C1.setText("O");
                        c7=-1;
                        if(c7+c8+c9 == -3 || c1+c4+c7 == -3 ||c7+c5+c3 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R3C1.setText("X");
                        c7=1;
                        if(c7+c8+c9 == 3 || c1+c4+c7 == 3 ||c7+c5+c3 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R3C1.setEnabled(FALSE);}
            }
        });

        R3C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R3C2.setText("O");
                        c8=-1;
                        if(c8+c7+c9 == -3 || c8+c5+c2 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R3C2.setText("X");
                        c8=1;
                        if(c8+c7+c9 == 3 || c8+c5+c2 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R3C2.setEnabled(FALSE);}
            }
        });

        R3C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct==0){count++;
                    if(count%2 == 0)
                    {
                        R3C3.setText("O");
                        c9=-1;
                        if(c7+c8+c9 == -3 || c3+c6+c9 == -3 ||c1+c5+c9 == -3)
                        {
                            textview.setText("Winner is " +s2);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    else
                    {
                        R3C3.setText("X");
                        c9=1;
                        if(c7+c8+c9 == 3 || c3+c6+c9 == 3 ||c1+c5+c9 == 3)
                        {
                            textview.setText("Winner is " +s1);
                            ct=1;
                        }
                        else if(count==9)
                        {
                            textview.setText("DRAW");
                        }
                    }
                    R3C3.setEnabled(FALSE);}
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1=c2=c3=c4=c5=c6=c7=c8=c9=ct=0;
                R1C1.setText("");
                R1C1.setEnabled(true);
                R1C2.setText("");
                R1C2.setEnabled(true);
                R1C3.setText("");
                R1C3.setEnabled(true);
                R2C1.setText("");
                R2C1.setEnabled(true);
                R2C2.setText("");
                R2C2.setEnabled(true);
                R2C3.setText("");
                R2C3.setEnabled(true);
                R3C1.setText("");
                R3C1.setEnabled(true);
                R3C2.setText("");
                R3C2.setEnabled(true);
                R3C3.setText("");
                R3C3.setEnabled(true);
                count=0;
                textview.setText("");
            }
        });
    }
}
