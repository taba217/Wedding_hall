package com.snaptech.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



import com.snaptech.R;
import com.snaptech.harith.Details;
import com.snaptech.harith.ExampleList;
import com.snaptech.harith.HallList;
import com.snaptech.harith.Halls;

import java.util.ArrayList;

public class main extends Fragment {
    private RecyclerView mRecyvlerView;
    private ExampleList mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Halls> hallsItems;
    View v;
      public main(){
         
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          v=inflater.inflate(R.layout.content_hall_list, container, false);
          fragmentActivity();
          create();
     //   buildRecycler(v);
        return v;
    }

    private void fragmentActivity() {



    }

    private void buildRecycler(View v) {
        //View v = findViewById(R.id.content);
        mRecyvlerView = v.findViewById(R.id.recycler);
        mRecyvlerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleList(hallsItems,getActivity());

        mRecyvlerView.setLayoutManager(mLayoutManager);
        mRecyvlerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleList.onItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Toast.makeText(getActivity(), i+"", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), Details.class));
            }
        });
    }

    public void create() {

        hallsItems = new ArrayList<>();
//        hallsItems.add(new Halls("1.png","Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls("1.png","Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls("1.png","Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls("1.png","Virgina","200 SD","Soba - Soba-west"));
//        hallsItems = new ArrayList<>();
//        hallsItems.add(new Halls(R.drawable.hall_1,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.drawable.hall_2,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.drawable.hall_1,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.drawable.hall_2,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.drawable.hall_1,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.drawable.hall_2,"Virgina","200 SD","Soba - Soba-west"));
    }
}
