package com.jh.imoocmusic.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jh.imoocmusic.R;
import com.jh.imoocmusic.model.AlbumModel;
import com.jh.imoocmusic.ui.activity.AlbumListActivity;

import java.util.List;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder>{

    private Context mContext;
    private List<AlbumModel> mDataSource;


    public MusicGridAdapter (Context context) {
        mContext = context;
    }

    public MusicGridAdapter (Context context, List<AlbumModel> dataSource) {
        mContext = context;
        this.mDataSource = dataSource;
    }


    @NonNull
    @Override
    public MusicGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicGridAdapter.ViewHolder viewHolder, int i) {

        Glide.with(mContext)
                .load("https://avatars0.githubusercontent.com/u/24784194?s=460&v=4")
                .into(viewHolder.ivIcon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlbumListActivity.class);
//                intent.putExtra(AlbumListActivity.ALBUM_ID, albumModel.getAlbumId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIcon;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }

    }
}
