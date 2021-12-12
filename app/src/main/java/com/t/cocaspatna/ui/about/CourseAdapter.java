package com.t.cocaspatna.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.t.cocaspatna.R;

import java.util.List;

public class CourseAdapter extends PagerAdapter {

    private Context context;
    private List<CourseModel> list;

    public CourseAdapter(Context context, List<CourseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_item_layout,container,false);

        ImageView imageView;
        TextView  CourseTitle, course_des;

        imageView = view.findViewById(R.id.courseIcon);
        CourseTitle = view.findViewById(R.id.coursetitle);
        course_des = view.findViewById(R.id.description);

        imageView.setImageResource(list.get(position).getImg());
        CourseTitle.setText(list.get(position).getTitle());
        course_des.setText(list.get(position).getDescription());

        container.addView(view,0);

        return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
