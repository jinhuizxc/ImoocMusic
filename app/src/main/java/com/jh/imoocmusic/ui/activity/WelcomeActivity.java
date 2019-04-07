package com.jh.imoocmusic.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 延迟3秒，跳转页面
 */
public class WelcomeActivity extends BaseActivity {

    private Timer timer;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }


    @Override
    protected void initView() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                toMain();
                toLogin();
            }
        }, 3 * 1000);
    }

    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
