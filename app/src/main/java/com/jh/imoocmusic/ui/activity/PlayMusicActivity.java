package com.jh.imoocmusic.ui.activity;

import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;
import com.jh.imoocmusic.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {


    private ImageView mIvBg;
    private TextView mTvName, mTvAuthor;
    private PlayMusicView playMusicView;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_music;
    }

    @Override
    protected void initView() {
        super.initView();

      // 隐藏statusBar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mIvBg = fd(R.id.iv_bg);
        mTvName = fd(R.id.tv_name);
        mTvAuthor = fd(R.id.tv_author);
        // glide-transformations  高斯模糊效果
        /**
         *  radius 模糊程度,  sampling 原图的宽高比
         */
        Glide.with(this)
                .load("https://avatars0.githubusercontent.com/u/24784194?s=460&v=4")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);

        playMusicView = fd(R.id.play_music_view);
        playMusicView.setMusicIcon("https://avatars0.githubusercontent.com/u/24784194?s=460&v=4");

        // 播放音乐
        playMusicView.playMusic("http://res.lgdsunday.club/Nostalgic%20Piano.mp3");

    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View view){
        onBackPressed();
    }
}
