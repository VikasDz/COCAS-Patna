package com.t.cocaspatna.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.t.cocaspatna.R;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        
        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);



        setSliderView();
        map = view.findViewById(R.id.map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return  view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=College of Commerce, Arts and Science ,Patna");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i = 0; i<5; i++){

          DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0030-1024x682.jpg?alt=media&token=5042c004-b751-473d-b600-389164feb670");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0029-1024x682.jpg?alt=media&token=cf7a9237-47fd-49df-9a89-9591bce797c9");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0092-1024x682.jpg?alt=media&token=a585826f-0c6f-4b29-baa3-af30b9e5496e");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0047-1024x682.jpg?alt=media&token=cf5c3fe4-1f6d-428d-8a03-2ee645938a64");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0040-1080x720.jpg?alt=media&token=b4500230-896e-4cb6-93ba-025a3ac134aa");
                    break;


            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}