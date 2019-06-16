package com.example.dell.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

class AI
{
    int i;
    int j;
    int score;

    public AI(int s) {
        score = s;
    }
};

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] board = new Button[3][3];
    private boolean MyTurn = true;
    TextView result;
    Button reset;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        board[0][0] = (Button)findViewById(R.id.button11C);
        board[0][1] = (Button)findViewById(R.id.button12C);
        board[0][2] = (Button)findViewById(R.id.button13C);
        board[1][0] = (Button)findViewById(R.id.button21C);
        board[1][1] = (Button)findViewById(R.id.button22C);
        board[1][2] = (Button)findViewById(R.id.button23C);
        board[2][0] = (Button)findViewById(R.id.button31C);
        board[2][1] = (Button)findViewById(R.id.button32C);
        board[2][2] = (Button)findViewById(R.id.button33C);
        result = (TextView)findViewById(R.id.textview_1);
        reset = (Button)findViewById(R.id.resetC);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j].setOnClickListener(this);
            }
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnable(true);
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        board[i][j].setText("");
                    }
                }
                result.setText("");
                c=0;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals(""))
        {
            return;
        }
        ((Button) v).setText("X");
        if(checkWIN())
        {
            result.setText("Winner : YOU");
            setEnable(false);
        }
        else if(checkDRAW())
        {
            result.setText("DRAW");
            setEnable(false);
        }
        else {
            getComputerMove();
            if(checkWIN())
            {
                result.setText("Winner : Computer");
                setEnable(false);
            }
            else if(checkDRAW())
            {
                result.setText("DRAW");
                setEnable(false);
            }
        }
    }

    private void getRandomMove()
    {
        Random rand = new Random();
        int x = rand.nextInt(3);
        int y = rand.nextInt(3);
        if(board[x][y].getText().toString().equals(""))
        {
            board[x][y].setText("O");
            return;
        }
        else
        {
            getComputerMove();
        }
    }

    private void getComputerMove() {
        if(c==0)
        {
            c=1;
            getRandomMove();
        }
        else
        {
            AI ans = miniMax(1);
            board[ans.i][ans.j].setText("O");
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

    AI miniMax(int player)
    {
        if(checkWIN())
        {
            return new AI(-player);
        }
        if(checkDRAW())
        {
            return new AI(0);
        }

        AI min = new AI(0);
        AI max = new AI(0);
        min.score = Integer.MAX_VALUE;
        max.score = Integer.MIN_VALUE;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                String s = board[i][j].getText().toString();
                if(s.equals(""))
                {
                    AI ai = new AI(0);
                    ai.i = i;
                    ai.j = j;
                    if(player == 1)
                    {
                        //Toast.makeText(Main3Activity.this,ai.i + " " + ai.j,Toast.LENGTH_SHORT).show();
                        board[i][j].setText("O");
                        ai.score = miniMax(-1).score;
                    }
                    else
                    {
                        board[i][j].setText("X");
                        ai.score = miniMax(1).score;
                    }
                    if(max.score < ai.score)
                    {
                        max = ai;
                    }
                    if(min.score > ai.score)
                    {
                        min = ai;
                    }
                    board[i][j].setText("");
                }
            }
        }

        if(player == 1)
        {
            return max;
        }
        else
        {
            return min;
        }
    }
}
