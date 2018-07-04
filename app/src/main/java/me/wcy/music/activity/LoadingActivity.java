package me.wcy.music.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

import me.wcy.music.R;

public class LoadingActivity extends FragmentActivity {

    private Timer timer;

    final Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Intent intent = new Intent(LoadingActivity.this,MusicActivity.class);
                    startActivity(intent);
                    timer.cancel();
                    finish();

                    break;
            }
            super.handleMessage(msg);
        }
    };
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading);


        timer = new Timer(true);
        timer.schedule(task,3500);
    }

    TimerTask task = new TimerTask(){
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };
}
