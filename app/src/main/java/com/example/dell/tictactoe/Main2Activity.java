package com.example.dell.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] board = new Button[3][3];
    private boolean MyTurn = true;
    TextView result,player1,player2;
    Button reset;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent ii = getIntent();
        s1 = ii.getStringExtra("first");
        s2 = ii.getStringExtra("second");


        board[0][0] = (Button) findViewById(R.id.button11);
        board[0][1] = (Button) findViewById(R.id.button12);
        board[0][2] = (Button) findViewById(R.id.button13);
        board[1][0] = (Button) findViewById(R.id.button21);
        board[1][1] = (Button) findViewById(R.id.button22);
        board[1][2] = (Button) findViewById(R.id.button23);
        board[2][0] = (Button) findViewById(R.id.button31);
        board[2][1] = (Button) findViewById(R.id.button32);
        board[2][2] = (Button) findViewById(R.id.button33);
        result = (TextView) findViewById(R.id.textview);
        player1 = (TextView) findViewById(R.id.text_player1);
        player2 = (TextView) findViewById(R.id.text_player2);
        reset = (Button) findViewById(R.id.reset);

        player1.setText("Player1 : " + s1);
        player2.setText("Player2 : " + s2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setOnClickListener(this);
            }
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnable(true);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j].setText("");
                    }
                }
                result.setText("");
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals(""))
        {
            return;
        }
        if(MyTurn)
        {
            ((Button) v).setText("X");
            if(checkWIN())
            {
                result.setText("Winner is " + s1);
                setEnable(false);
            }
            else if(checkDRAW())
            {
                result.setText("Draw");
                setEnable(false);
            }
            MyTurn = false;
        }
        else
        {
            ((Button) v).setText("O");
            if(checkWIN())
            {
                result.setText("Winner is " + s2);
                setEnable(false);
            }
            else if(checkDRAW())
            {
                result.setText("Draw");
                setEnable(false);
            }
            MyTurn = true;
        }
    }

    private void setEnable(boolean b) {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j].setEnabled(b);
            }
        }
    }

    private boolean checkDRAW() {
        String[][] s = new String[3][3];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s[i][j] = board[i][j].getText().toString();
            }
        }

        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(s[i][j].equals(""))
                {
                    count++;
                }
            }
        }
        return (count==0);
    }

    private boolean checkWIN()
    {
        String[][] s = new String[3][3];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s[i][j] = board[i][j].getText().toString();
            }
        }

        for(int i=0;i<3;i++)
        {
            if(s[i][0].equals(s[i][1]) && s[i][1].equals(s[i][2]) && !s[i][0].equals(""))
            {
                return true;
            }
        }

        for(int i=0;i<3;i++)
        {
            if(s[0][i].equals(s[1][i]) && s[1][i].equals(s[2][i]) && !s[0][i].equals(""))
            {
                return true;
            }
        }

        if(s[0][0].equals(s[1][1]) && s[1][1].equals(s[2][2]) && !s[0][0].equals(""))
        {
            return true;
        }

        if(s[0][2].equals(s[1][1]) && s[1][1].equals(s[2][0]) && !s[0][2].equals(""))
        {
            return true;
        }

        return false;
    }
}
