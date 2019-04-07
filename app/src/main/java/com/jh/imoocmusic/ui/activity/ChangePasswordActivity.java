package com.jh.imoocmusic.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() {
        initNavBar(true, "修改密码", false);
    }

    /**
     * 确认新密码
     * @param view
     */
    public void onPasswordConfirmClick(View view){

    }
}
