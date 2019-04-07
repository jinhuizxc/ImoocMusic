package com.jh.imoocmusic.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;
import com.jh.imoocmusic.ui.adapter.MusicGridAdapter;
import com.jh.imoocmusic.ui.adapter.MusicListAdapter;
import com.jh.imoocmusic.views.GridSpaceItemDecoration;

/**
 * 图片地址：http://res.lgdsunday.club/poster-1.png
 *
 *  http://res.lgdsunday.club/poster-1.png
 *  https://avatars0.githubusercontent.com/u/24784194?s=460&v=4
 *
 *  音乐地址：http://res.lgdsunday.club/Nostalgic%20Piano.mp3
 *
 */
public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initNavBar(false, "慕课音乐", true);

        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mGridAdapter = new MusicGridAdapter(this);
        // 设置分割线
//        mRvGrid.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.HORIZONTAL));
        mRvGrid.setNestedScrollingEnabled(false);
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(
                getResources().getDimensionPixelSize(R.dimen.albumMarginSize),
                mRvGrid));
        mRvGrid.setAdapter(mGridAdapter);

        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
         */

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdapter(this, mRvList);
        mRvList.setAdapter(mListAdapter);
    }
}
