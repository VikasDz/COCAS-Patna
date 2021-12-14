package com.t.cocaspatna.ui.faculty;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.t.cocaspatna.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {


    private List<com.t.cocaspatna.ui.faculty.TeacherData> list;
    private Context context;
    private String category;

    public TeacherAdapter(List<com.t.cocaspatna.ui.faculty.TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.teachers_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position)  {

        com.t.cocaspatna.ui.faculty.TeacherData item = list.get(position);
        holder.name.setText(item.getTeacherName());
        holder.post.setText(item.getTeacherpost());
        holder.email.setText(item.getTeacheremail());
        try {
            Glide.with(context).load(item.getTeacherimage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, email, post;
        private ImageView imageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teachersName);
            email = itemView.findViewById(R.id.teachersEmail);
            post = itemView.findViewById(R.id.teachersPost);
            imageView = itemView.findViewById(R.id.teachersImage);
        }
    }
}
