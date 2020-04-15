package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int second =0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runner();
    }

    private void runner() {
        final TextView timeview=findViewById(R.id.text);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = second/3600;
                int min = (second%3600)/60;
                int sec = second % 60;
                String time = String.format("%d:%02d:%02d",hour,min,sec);
                timeview.setText(time);
                if(running){
                    second++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    public void OnStart(View view) {
        running = true;
    }

    public void OnStop(View view) {
        running = false;
    }

    public void OnReset(View view) {
        running = false;
        second = 0;

    }
}
