package com.example.funquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {
    ImageButton imgbtn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgbtn_start=(ImageButton) findViewById(R.id.btn_start);

        MediaPlayer mediaPlayer=MediaPlayer.create(HomeActivity.this,R.raw.mono);
        mediaPlayer.start();

        imgbtn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
            }
        });
    }
}