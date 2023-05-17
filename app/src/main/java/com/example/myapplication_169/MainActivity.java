package com.example.myapplication_169;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner=false;
    int imageclicked=-1;
    int [][]winningstates={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{1,4,7},{0,3,6},{2,5,8}};
    int []gamestates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int player=1; //player 1 is cross
    public void load(View view){
        int tag = Integer.parseInt(view.getTag().toString());
        imageclicked=gamestates[tag];
        ImageView v = (ImageView) view;
        if(iswinner==false && imageclicked==-1) {

            if (player == 1) {
                gamestates[tag] = player;
                v.setImageResource(R.drawable.cross);
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero1);
                gamestates[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningstates.length; i++) {
                if (gamestates[winningstates[i][0]] == gamestates[winningstates[i][1]] && gamestates[winningstates[i][1]] == gamestates[winningstates[i][2]] && gamestates[winningstates[i][0]] > -1) {
                    Toast.makeText(this, "winnner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    iswinner=true;
                }
            }
        }
    }
    public  void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView)gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner=false;
        imageclicked=-1;
        player=1;
        for(int i=0;i<gamestates.length;i++){
            gamestates[i]=-1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}