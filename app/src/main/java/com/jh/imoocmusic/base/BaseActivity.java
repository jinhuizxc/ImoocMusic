package com.jh.imoocmusic.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.ui.activity.MeActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private ImageView iv_back, iv_me;
    private TextView tv_title;


    // 封装findViewById方法；
    protected <T extends View> T fd(@IdRes int id){
        return findViewById(id);
    }


    /**
     * 初始化NavBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack, String title, boolean isShowMe){
        iv_back = fd(R.id.iv_back);
        tv_title = fd(R.id.tv_title);
        iv_me = fd(R.id.iv_me);

        iv_back.setVisibility(isShowBack ? View.VISIBLE: View.GONE);
        iv_me.setVisibility(isShowMe ? View.VISIBLE: View.GONE);
        tv_title.setText(title);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        iv_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        // 初始化view
        initView();
    }

    // 初始化控件
    protected abstract int getLayoutId();

    protected  void initView(){

    };


}
