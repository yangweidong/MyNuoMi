package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.activity.ShopImage;

import java.util.List;

/**
 * Created by yangweidong on 16/1/20.
 */
public class ShopInfoAdapter extends RecyclerView.Adapter<ShopInfoAdapter.ViewHolder> {


    List<ShopImage> shopImages;

    public ShopInfoAdapter(List<ShopImage> shopImages) {
        this.shopImages = shopImages;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_info_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri uri = Uri.parse(shopImages.get(position).getImageurl());
        holder.shop_image.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return shopImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView shop_image;

        public ViewHolder(View itemView) {
            super(itemView);
            shop_image = (SimpleDraweeView) itemView.findViewById(R.id.shop_image);
        }

    }
}
