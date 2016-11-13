package com.tatweer.moh.takamulpoc.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.Models.Invention;
import com.tatweer.moh.takamulpoc.R;

import java.util.List;

/**
 * Created by moh on 11/9/2016.
 */

public class FavouritesAdapter extends BaseAdapter {

    LayoutInflater inflater;
    private Context mContext;
    private List<Invention> inventionList;
    private Activity mActivity;



    public FavouritesAdapter(Context mContext, List<Invention> inventionList, Activity mActivity) {
        this.mContext = mContext;
        this.inventionList = inventionList;
        this.mActivity = mActivity;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return inventionList.size();
    }

    @Override
    public Invention getItem(int position) {
        return inventionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.album_fav_card, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Invention invention = inventionList.get(position);
        mViewHolder.title.setText(invention.getName());
        mViewHolder.count.setText(invention.getDetail());
        mViewHolder.backers.setText(Integer.toString(invention.getBackers()));
        mViewHolder.funded.setText(Integer.toString(invention.getProgress())+"%");
        mViewHolder.daysToGo.setText(Integer.toString(invention.getDaysToGo()));
        mViewHolder.category.setText(invention.getCategory());
        mViewHolder.progressBar.setMax(100);
        mViewHolder.progressBar.setProgress(invention.getProgress());
        mViewHolder.progressBar.setActivated(true);
        mViewHolder.progressBar.show();

        // loading invention cover using Glide library
        Glide.with(mContext).load(invention.getThumbnail()).into(mViewHolder.thumbnail);

//        ImageView newImage = new ImageView(mContext);
//
//        newImage.setImageBitmap(bitmapWithImage);

//        mViewHolder.share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FlipShareView share = new FlipShareView.Builder(mActivity, view)
//                        .addItem(new ShareItem("Facebook", Color.WHITE, 0xff43549C, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.facebook)))
//                        .addItem(new ShareItem("Twitter", Color.WHITE, 0xff4999F0, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.twitter)))
//                        .addItem(new ShareItem("Instagram", Color.WHITE, 0xffD9392D, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.instagram)))
//                        .addItem(new ShareItem("Watsapp", Color.WHITE, 0xff275F5E, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.whatsup)))
//                        .addItem(new ShareItem("Skype", Color.WHITE, 0xff00AFF0, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.skype)))
//                        .setBackgroundColor(0x60000000)
//                        .setItemDuration(100)
//                        .setSeparateLineColor(0x30000000)
//                        .setAnimType(FlipShareView.TYPE_VERTICLE)
//                        .create();
//
//                share.setOnFlipClickListener(new FlipShareView.OnFlipClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
//                        Toast.makeText(mActivity, "position " + position + " is clicked.", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void dismiss() {
//                    }
//                });
//            }
//        });

        return convertView;
    }




    private class MyViewHolder {
        public TextView title, count, category, funded, backers, daysToGo, alreadyFunded;
        public ImageView thumbnail, like, share;
        public ContentLoadingProgressBar progressBar;

        public MyViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            category = (TextView) view.findViewById(R.id.category);
            count = (TextView) view.findViewById(R.id.count);
            funded = (TextView) view.findViewById(R.id.funded);
            backers = (TextView) view.findViewById(R.id.backers);
            alreadyFunded = (TextView) view.findViewById(R.id.alreadyFunded);
            daysToGo = (TextView) view.findViewById(R.id.daysToGo);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            like = (ImageView) view.findViewById(R.id.likeImageView);
            share = (ImageView) view.findViewById(R.id.shareImageView);
            progressBar = (ContentLoadingProgressBar) view.findViewById(R.id.progress);
        }
    }
}