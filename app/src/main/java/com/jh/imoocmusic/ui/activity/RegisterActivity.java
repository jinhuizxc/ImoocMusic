package com.jh.imoocmusic.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;

public class RegisterActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        initNavBar(true, "注册", false);
    }


    /**
     * 跳转注册
     * @param view
     */
    public void onRegisterClick(View view) {

    }

}
