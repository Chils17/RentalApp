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
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.rentalapp.R;
import com.webmyne.rentalapp.helper.TouchImageView;
import com.webmyne.rentalapp.model.ProductImage;
import com.webmyne.rentalapp.ui.FullScreenActivity;

import java.util.ArrayList;

/**
 * Created by chiragpatel on 18-07-2017.
 */

public class FullScreenImageAdapter extends PagerAdapter {
    Context context;
    private ArrayList<ProductImage> imagesList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public FullScreenImageAdapter(Context context, ArrayList<ProductImage> images) {
        this.context = context;
        this.imagesList = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.fullscreen_image, container, false);

        final TouchImageView imageView = (TouchImageView) itemView.findViewById(R.id.imgDisplay);
        final ProgressBar progress = (ProgressBar) itemView.findViewById(R.id.progress);

        progress.setVisibility(View.VISIBLE);
        Glide.with(context)
                .load(imagesList.get(position).getImg_url())
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
                .into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}
