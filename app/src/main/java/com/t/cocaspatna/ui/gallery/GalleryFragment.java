package com.t.cocaspatna.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t.cocaspatna.R;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class GalleryFragment extends Fragment {


    RecyclerView convRecycler,otherRecycler;
    GalleryAdapter adapter;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);
        convRecycler = view.findViewById(R.id.convRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar2 = view.findViewById(R.id.progressBar2);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getCovImage();

        getOtherImage();

        return  view;
    }

    private void getCovImage() {
        reference.child("Principal’s Gallery").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }
                
                adapter = new GalleryAdapter(getContext(),imageList);
                convRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                progressBar.setVisibility(View.GONE);
                convRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Nothing Found", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void getOtherImage() {
        reference.child("Others Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                progressBar2.setVisibility(View.GONE);
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar2.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Nothing Found", Toast.LENGTH_SHORT).show();

            }
        });

    }
}