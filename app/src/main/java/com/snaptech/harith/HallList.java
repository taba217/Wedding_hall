package com.snaptech.harith;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;



import com.snaptech.R;
import com.snaptech.ScrollingActivity;

import java.util.ArrayList;

public class HallList extends AppCompatActivity {

    private RecyclerView mRecyvlerView;
    private ExampleList mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Halls> hallsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_hall_list);
        // Start My Code
        create();
        buildRecycler();
    }




    private void buildRecycler() {
        //View v = findViewById(R.id.content);

       mRecyvlerView = findViewById(R.id.recycler);
        mRecyvlerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleList(hallsItems,this);

        mRecyvlerView.setLayoutManager(mLayoutManager);
        mRecyvlerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleList.onItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Toast.makeText(HallList.this, i+"", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(HallList.this, ScrollingActivity.class));
            }
        });
    }
    void showAlert(String msg) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg).setCancelable(false)
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        try {
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create() {
        hallsItems = new ArrayList<Halls>();
     hallsItems.add(new Halls("1.png","Virgina","200 SD","","","","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.mipmap.hall2,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.mipmap.hall1,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.mipmap.hall2,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.mipmap.hall1,"Virgina","200 SD","Soba - Soba-west"));
//        hallsItems.add(new Halls(R.mipmap.hall2,"Virgina","200 SD","Soba - Soba-west"));

    }
}
