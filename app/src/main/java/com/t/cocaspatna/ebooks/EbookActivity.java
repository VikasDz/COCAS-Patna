package com.t.cocaspatna.ebooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t.cocaspatna.R;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycle;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;
     ShimmerFrameLayout shimmer_view_container;
     LinearLayout shimmerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        ebookRecycle = findViewById(R.id.ebookRecycle);
        shimmer_view_container = findViewById(R.id.shimmer_view_container);
        shimmerLayout = findViewById(R.id.shimmerLayout);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");
        
        
        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    EbookData data = snapshot1.getValue(EbookData.class);
                    list.add(data);

                }
                adapter =  new EbookAdapter(EbookActivity.this,list);
                ebookRecycle.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycle.setAdapter(adapter);
                shimmer_view_container.stopShimmer();
                shimmerLayout.setVisibility(View.GONE);

                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onPause() {
        shimmer_view_container.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmer_view_container.startShimmer();
        super.onResume();
    }
}