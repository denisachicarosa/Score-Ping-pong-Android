package com.example.teodora.ping_pongscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button leftBtn;
    Button rightBtn;
    Button undoBtn;
    Button resetBtn;

    Button netLBtn;
    Button netRBtn;

    TextView netsLeft;
    TextView netsRight;

    TextView left;
    TextView right;

    Integer lastPressedBtn = 0;
    ArrayList<Integer> moves = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftBtn = (Button) findViewById(R.id.leftBtn);
        rightBtn = (Button) findViewById(R.id.rightBtn);
        undoBtn = (Button) findViewById(R.id.undoBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);

        left = (TextView) findViewById(R.id.left);
        right = (TextView) findViewById(R.id.right);

        netLBtn = (Button) findViewById(R.id.netLeftBtn);
        netRBtn = (Button) findViewById(R.id.netRightBtn);

        netsLeft = (TextView) findViewById(R.id.netLeft);
        netsRight = (TextView) findViewById(R.id.netRight);



        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l = String.valueOf(left.getText());
                Integer score = Integer.parseInt(l);

                score ++;

                l = score.toString();
                lastPressedBtn = 1;
                moves.add(lastPressedBtn);

                left.setText(l);

            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = String.valueOf(right.getText());
                Integer score = Integer.parseInt(l);

                score ++;

                l = score.toString();

                lastPressedBtn = 2;
                moves.add(lastPressedBtn);
                right.setText(l);
            }
        });

        undoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (! moves.isEmpty()) {
                    lastPressedBtn = moves.get(moves.size()-1);
                    moves.remove(moves.size()-1);
                    if (lastPressedBtn == 1) {
                        String l = String.valueOf(left.getText());
                        Integer score = Integer.parseInt(l);
                        if(score > 0)
                            score --;

                        l = score.toString();


                        left.setText(l);
                    }
                    else if (lastPressedBtn == 2) {
                        String l = String.valueOf(right.getText());
                        Integer score = Integer.parseInt(l);
                        if (score > 0)
                            score --;

                        l = score.toString();


                        right.setText(l);
                    }
                    else if (lastPressedBtn == 3) {
                        String l = String.valueOf(netsLeft.getText());
                        Integer score = Integer.parseInt(l);
                        if(score > 0)
                            score --;
                        l = score.toString();

                        netsLeft.setText(l);
                    }
                    else if (lastPressedBtn == 4) {
                        String l = String.valueOf(netsRight.getText());
                        Integer score = Integer.parseInt(l);
                        if(score > 0)
                            score --;
                        l = score.toString();

                        netsRight.setText(l);
                    }

                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer score = 0;
                String l = score.toString();
                left.setText(l);
                right.setText(l);

            }
        });

        netLBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = String.valueOf(netsLeft.getText());
                Integer score = Integer.parseInt(l);

                score ++;

                if ( score < 2) {
                    l = score.toString();
                    lastPressedBtn = 3;
                    moves.add(lastPressedBtn);
                }
                else {
                    score = 0;
                    l = score.toString();
                    String r = String.valueOf(right.getText());
                    Integer scor = Integer.parseInt(r);

                    scor ++;

                    r = scor.toString();

                    lastPressedBtn = 2;
                    moves.add(lastPressedBtn);
                    right.setText(r);
                }

                netsLeft.setText(l);
            }
        });
        netRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = String.valueOf(netsRight.getText());
                Integer score = Integer.parseInt(l);

                score ++;

                if ( score < 2) {
                    l = score.toString();
                    lastPressedBtn = 4;
                    moves.add(lastPressedBtn);
                }
                else {
                    score = 0;
                    l = score.toString();
                    String r = String.valueOf(left.getText());
                    Integer scor = Integer.parseInt(r);

                    scor ++;

                    r = scor.toString();

                    lastPressedBtn = 1;
                    moves.add(lastPressedBtn);
                    left.setText(r);
                }

                netsRight.setText(l);
            }
        });

    }
}
