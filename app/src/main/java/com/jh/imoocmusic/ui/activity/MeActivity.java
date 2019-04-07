package com.jh.imoocmusic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;
import com.jh.imoocmusic.utils.UserUtil;

public class MeActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_me;
    }

    @Override
    protected void initView() {
        super.initView();
        initNavBar(true, "个人中心", false);
    }

    /**
     * 修改密码
     * @param view
     */
    public void onChangeClick(View view) {
        ActivityUtils.startActivity(ChangePasswordActivity.class);
    }

    /**
     * 退出登录
     * @param view
     */
    public void onLogoutClick(View view) {
        UserUtil.logout(this);
    }
}
