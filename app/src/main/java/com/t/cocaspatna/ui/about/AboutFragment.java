package com.t.cocaspatna.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.t.cocaspatna.R;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;


public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private  CourseAdapter adapter;
    private List<CourseModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_education,"Intermediate" , "Arts & Science.==="));
        list.add(new CourseModel(R.drawable.ic_education,"Undergraduate Courses" , "Commerce, Arts & Science"));

        adapter = new CourseAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.ViewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.collegeImage);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/cocas-f637c.appspot.com/o/Banner%2FIMG-20200731-WA0029-1024x682.jpg?alt=media&token=cf7a9237-47fd-49df-9a89-9591bce797c9")
                .into(imageView);


        return  view;
    }
}