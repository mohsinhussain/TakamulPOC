package com.tatweer.moh.takamulpoc.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.Models.Category;
import com.tatweer.moh.takamulpoc.R;

import java.util.List;

/**
 * Created by moh on 11/9/2016.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoriesList;
    private Activity mActivity;

    public CategoriesAdapter(Context mContext, List<Category> categoriesList, Activity mActivity) {
        this.mContext = mContext;
        this.categoriesList = categoriesList;
        this.mActivity = mActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Category category = categoriesList.get(position);
        holder.title.setText(category.getName());
        holder.count.setText(category.getProductsCount()+" Products");

        // loading invention cover using Glide library
        Glide.with(mContext).load(category.getImage()).into(holder.thumbnail);


//        holder.mRootView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(mActivity, DetailActivity.class);
//                i.putExtra("category", invention.getCategory());
//                i.putExtra("title", invention.getName());
//                i.putExtra("progress", invention.getProgress());
//                i.putExtra("backers", invention.getBackers());
//                i.putExtra("daysToGo", invention.getDaysToGo());
//                i.putExtra("image", invention.getThumbnail());
//                i.putExtra("detail", invention.getDetail());
//                mActivity.startActivity(i);
//            }
//        });
    }



    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;
        public View mRootView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            mRootView = view;
        }
    }


}

