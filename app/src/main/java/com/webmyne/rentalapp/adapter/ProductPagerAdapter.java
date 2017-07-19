package com.webmyne.rentalapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.helper.AppConstants;
import com.webmyne.rentalapp.ui.ProfileActivity;

import java.util.ArrayList;

public class ProductPagerAdapter extends PagerAdapter {

    private ArrayList<String> images_url = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public ProductPagerAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images_url = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images_url.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.item_slide_product_adapter, view, false);
        AppConstants.HEIGHT = context.getResources().getDisplayMetrics().heightPixels;
        AppConstants.WIDTH = context.getResources().getDisplayMetrics().widthPixels;
        ImageView imageProduct = (ImageView) myImageLayout
                .findViewById(R.id.iv_product);
        final ProgressBar progress = (ProgressBar) myImageLayout
                .findViewById(R.id.progress);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, AppConstants.HEIGHT / 3);
        imageProduct.setLayoutParams(layoutParams);
        progress.setVisibility(View.VISIBLE);
        Glide.with(context)
                .load(images_url.get(position))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progress.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageProduct)
        ;
        /*Glide.with(context).load(images_url.get(position)).fitCenter().placeholder(R.drawable.book_1)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageProduct);*/
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}