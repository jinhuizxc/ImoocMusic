package com.jh.imoocmusic.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.imoocmusic.R;
import com.jh.imoocmusic.base.BaseActivity;
import com.jh.imoocmusic.ui.adapter.MusicListAdapter;

public class AlbumListActivity extends BaseActivity {

    public static final String ALBUM_ID = "albumId";

    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_album_list;
    }

    @Override
    protected void initView() {
        super.initView();

        initNavBar(true, "专辑列表", false);

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mAdapter = new MusicListAdapter(this, null);
        mRvList.setAdapter(mAdapter);

    }
}
