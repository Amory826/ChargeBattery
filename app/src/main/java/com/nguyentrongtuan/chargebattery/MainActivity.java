package com.nguyentrongtuan.chargebattery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView chargeBattery;
    Button btn;
    int i = 1;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chargeBattery = (ImageView) findViewById(R.id.chargeBattery);
        btn = (Button) findViewById(R.id.btnXacPin);

        btn.setOnClickListener(this);

        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0) {
                    if (i < 5) {
                        i++;
                        chargeBattery.setImageLevel(i);
                    } else{
                        i = 0;
                        chargeBattery.setImageLevel(i);
                    }
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000, 1000);




    }

    @Override
    public void onClick(View v) {
        i++;
        chargeBattery.setImageLevel(i);
    }
}