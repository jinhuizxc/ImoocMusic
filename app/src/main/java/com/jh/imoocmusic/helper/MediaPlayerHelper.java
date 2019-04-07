package com.jh.imoocmusic.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * 音乐播放器工具类
 */
public class MediaPlayerHelper {

    private static MediaPlayerHelper instance;
    private Context mContext;
    private MediaPlayer mMediaPlayer;

    private OnMediaPlayerHelperListener onMediaPlayerHelperListener;

    private String mPath;  // 当前正在播放音乐的路径

    public void setListener(OnMediaPlayerHelperListener listener) {
        this.onMediaPlayerHelperListener = listener;
    }

    public static MediaPlayerHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (MediaPlayerHelper.class) {
                if (instance == null) {
                    instance = new MediaPlayerHelper(context);
                }
            }
        }
        return instance;

    }

    private MediaPlayerHelper(Context context) {
        mContext = context;
        mMediaPlayer = new MediaPlayer();
    }

    /**
     * 当前需要播放的音乐
     *
     * @param path
     */
    public void setPath(String path) {
        /**
         * 1、音乐正在播放，重置音乐播放状态
         * 2、设置播放音乐路径
         * 3、准备播放
         */
        mPath = path;
//        1、音乐正在播放，重置音乐播放状态
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.reset();
        }

//        2、设置播放音乐路径
        try {
            mMediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        3、准备播放
        mMediaPlayer.prepareAsync();
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (onMediaPlayerHelperListener != null) {
                    onMediaPlayerHelperListener.onPrepared(mp);
                }
            }
        });

    }

    /**
     * 返回正在播放的音乐路径
     *
     * @return
     */
    public String getPath() {
        return mPath;
    }

    /**
     * 播放音乐
     */
    public void start() {
        if (mMediaPlayer.isPlaying()) return;
        mMediaPlayer.start();
    }

    /**
     * 暂停播放
     */
    public void pause() {
        mMediaPlayer.pause();
    }


    public interface OnMediaPlayerHelperListener {
        void onPrepared(MediaPlayer mp);

        void onCompletion(MediaPlayer mp);
    }


}
