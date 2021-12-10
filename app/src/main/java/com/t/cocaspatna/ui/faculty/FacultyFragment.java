package com.t.cocaspatna.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t.cocaspatna.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView BcaDepartment, McaDepartment ,ISCDepartment ,BSCITDepartment;
    private LinearLayout BcaNoData,McaNoData,ISCNoData,BSCITNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private  TeacherAdapter adapter;
    private DatabaseReference reference, dbref;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        BSCITDepartment =  view.findViewById(R.id.BSCITDepartment);
        ISCDepartment =  view.findViewById(R.id.ISCDepartment);
        McaDepartment =  view.findViewById(R.id.McaDepartment);
        BcaDepartment =  view.findViewById(R.id.BcaDepartment);



        BSCITNoData =  view.findViewById(R.id.BSCITNoData);
        ISCNoData =  view.findViewById(R.id.ISCNoData);
        McaNoData =  view.findViewById(R.id.McaNoData);
        BcaNoData =  view.findViewById(R.id.BcaNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        BSCITDepartment();
        ISCDepartment();
        McaDepartment();
        BcaDepartment();

        return view;

    }

    private void BSCITDepartment() {
        dbref = reference.child("Bsc Department");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    BSCITNoData.setVisibility(View.VISIBLE);
                    BSCITDepartment.setVisibility(View.GONE);
                }else{
                    BSCITNoData.setVisibility(View.GONE);
                    BSCITDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    BSCITDepartment.setHasFixedSize(true);
                    BSCITDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list1, getContext());

                    BSCITDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ISCDepartment() {
        dbref = reference.child("Isc");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ISCNoData.setVisibility(View.VISIBLE);
                    ISCDepartment.setVisibility(View.GONE);
                }else{
                    ISCNoData.setVisibility(View.GONE);
                    ISCDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ISCDepartment.setHasFixedSize(true);
                    ISCDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list2, getContext());

                    ISCDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void McaDepartment() {
        dbref = reference.child("Mca");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    McaNoData.setVisibility(View.VISIBLE);
                    McaDepartment.setVisibility(View.GONE);
                }else{
                    McaNoData.setVisibility(View.GONE);
                    McaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    McaDepartment.setHasFixedSize(true);
                    McaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list3, getContext());

                    McaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BcaDepartment() {
        dbref = reference.child("Bca Department");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    BcaNoData.setVisibility(View.VISIBLE);
                    BcaDepartment.setVisibility(View.GONE);
                }else{
                    BcaNoData.setVisibility(View.GONE);
                    BcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    BcaDepartment.setHasFixedSize(true);
                    BcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list4, getContext());

                    BcaDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}