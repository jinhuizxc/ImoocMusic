package com.jh.imoocmusic.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jh.imoocmusic.R;
import com.jh.imoocmusic.helper.MediaPlayerHelper;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private View mView;
    private ImageView mIvIcon, mIvNeedle, mIvPlay;

    private FrameLayout mFlPlayMusic;
    private Animation mPlayMusicAnim, mPlayNeedleAnim, mStopNeedleAnim;

    private boolean isPlaying;

    private MediaPlayerHelper mediaPlayerHelper;
    private String mPath;


    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);
        mIvIcon = mView.findViewById(R.id.iv_icon);

        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        mIvNeedle = mView.findViewById(R.id.iv_needle);
        mIvPlay = mView.findViewById(R.id.iv_play);

        /**
         * 1、定义所需要执行的动画
         *      1、光盘转动的动画
         *      2、指针指向光盘的动画
         *      3、指针离开光盘的动画
         * 2、startAnimation
         */
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_music_anim);
        mPlayNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_needle_anim);
        mStopNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.stop_needle_anim);


        addView(mView);

        mediaPlayerHelper = MediaPlayerHelper.getInstance(mContext);
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path) {
        mPath = path;
        isPlaying = true;
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvNeedle.startAnimation(mPlayNeedleAnim);
        mIvPlay.setVisibility(View.GONE);


        /**
         *  1.判断当前音乐是否已经在播放
         *  2. 如果当前音乐已经在播放，直接执行start方法
         *  3. 如果当前播放的音乐不是需要播放的音乐。调用setPath方法
         */
        if (mediaPlayerHelper.getPath()!= null
                && mediaPlayerHelper.getPath().equals(path)){
            mediaPlayerHelper.start();
        }else {
            mediaPlayerHelper.setPath(path);
            mediaPlayerHelper.setListener(new MediaPlayerHelper.OnMediaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayerHelper.start();
                }

                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

    }

    /**
     * 停止播放
     */
    public void stopMusic() {
        isPlaying = false;
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);
        mIvPlay.setVisibility(View.VISIBLE);

        mediaPlayerHelper.pause();

    }

    /**
     * 切换播放状态
     */
    private void trigger() {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic(mPath);
        }
    }


    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String icon) {
        Glide.with(mContext)
                .load(icon)
                .into(mIvIcon);
    }

}
