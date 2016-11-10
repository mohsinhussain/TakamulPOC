package com.tatweer.moh.takamulpoc.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.Models.Invention;
import com.tatweer.moh.takamulpoc.R;

import java.util.List;

import me.wangyuwei.flipshare.FlipShareView;
import me.wangyuwei.flipshare.ShareItem;

/**
 * Created by moh on 11/9/2016.
 */

public class InventionsAdapter extends RecyclerView.Adapter<InventionsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Invention> inventionList;
    private Activity mActivity;

    public InventionsAdapter(Context mContext, List<Invention> inventionList, Activity mActivity) {
        this.mContext = mContext;
        this.inventionList = inventionList;
        this.mActivity = mActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Invention invention = inventionList.get(position);
        holder.title.setText(invention.getName());
        holder.count.setText(invention.getDetail());
        holder.backers.setText(Integer.toString(invention.getBackers()));
        holder.funded.setText(Integer.toString(invention.getProgress())+"%");
        holder.daysToGo.setText(Integer.toString(invention.getDaysToGo()));
        holder.category.setText(invention.getCategory());
        holder.progressBar.setMax(100);
        holder.progressBar.setProgress(invention.getProgress());
        holder.progressBar.setActivated(true);
        holder.progressBar.show();

        if(position==3){
            holder.alreadyFunded.setVisibility(View.VISIBLE);
        }
        // loading invention cover using Glide library
        Glide.with(mContext).load(invention.getThumbnail()).into(holder.thumbnail);

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLiked(holder.like);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlipShareView share = new FlipShareView.Builder(mActivity, view)
                        .addItem(new ShareItem("Facebook", Color.WHITE, 0xff43549C, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.facebook)))
                        .addItem(new ShareItem("Twitter", Color.WHITE, 0xff4999F0, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.twitter)))
                        .addItem(new ShareItem("Instagram", Color.WHITE, 0xffD9392D, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.instagram)))
                        .addItem(new ShareItem("Watsapp", Color.WHITE, 0xff275F5E, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.whatsup)))
                        .addItem(new ShareItem("Skype", Color.WHITE, 0xff00AFF0, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.skype)))
                        .setBackgroundColor(0x60000000)
                        .setItemDuration(100)
                        .setSeparateLineColor(0x30000000)
                        .setAnimType(FlipShareView.TYPE_VERTICLE)
                        .create();

                share.setOnFlipClickListener(new FlipShareView.OnFlipClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(mActivity, "position " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void dismiss() {
                    }
                });
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void setLiked(ImageView view) {
        // inflate menu
        if(view.getDrawable().getConstantState().equals
                (mContext.getResources().getDrawable(R.drawable.heart_un_selected).getConstantState()))
        {
            view.setImageDrawable(mContext.getResources().getDrawable(R.drawable.heart_selected));
        }
        else
        {
            view.setImageDrawable(mContext.getResources().getDrawable(R.drawable.heart_un_selected));
        }

    }

    @Override
    public int getItemCount() {
        return inventionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count, category, funded, backers, daysToGo, alreadyFunded;
        public ImageView thumbnail, like, share;
        public ContentLoadingProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
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

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}

