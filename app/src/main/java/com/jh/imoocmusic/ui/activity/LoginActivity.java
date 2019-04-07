package com.jh.imoocmusic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;
import com.jh.imoocmusic.utils.UserUtil;
import com.jh.imoocmusic.views.InputView;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    private InputView inputPhone, inputPassword;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initNavBar(false, "登录", false);
        inputPhone = fd(R.id.input_phone);
        inputPassword = fd(R.id.input_password);
    }

    /**
     * 跳转注册
     * @param view
     */
    public void onRegisterClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录
     * @param view
     */
    public void onCommitClick(View view) {
        String phone = inputPhone.getInputStr();
        String password = inputPassword.getInputStr();

        // 验证用户输入是否合法
//        if (!UserUtil.validateLogin(this, phone, password)){
//            return;
//        }
        // 跳转应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
