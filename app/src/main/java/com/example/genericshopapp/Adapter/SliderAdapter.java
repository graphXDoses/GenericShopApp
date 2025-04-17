package com.example.genericshopapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.genericshopapp.Domain.BannerModel;
import com.example.genericshopapp.R;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewholder>
{
    private ArrayList<BannerModel> sliderItems;
    private ViewPager2 viewPager2;
    private Context context;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    public SliderAdapter(){ this.sliderItems = new ArrayList<>(); }

    public SliderAdapter(ArrayList<BannerModel> sliderItems, ViewPager2 viewPager2)
    {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapter.SliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        return new SliderViewholder(LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderViewholder holder, int position)
    {
        holder.setImage(sliderItems.get(position));
        if(position == sliderItems.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount()
    {
        return sliderItems.size();
    }

    public class SliderViewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public SliderViewholder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }

        void setImage(BannerModel bannerModel){
            Glide.with(context)
                    .load(bannerModel.getUrl())
                    .into(imageView);
        }
    }


}
