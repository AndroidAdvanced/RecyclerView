package com.app.mgu.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.app.mgu.recyclerview.adapter.AdapterData;
import com.app.mgu.recyclerview.adapter.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final RecyclerView.Adapter adapter  = new AdapterData();
        LinearLayoutManager l = new LinearLayoutManager(this);
        l.setOrientation(LinearLayoutManager.VERTICAL);
        ((RecyclerView) findViewById(R.id.recyclerView)).setAdapter(adapter);
        ((RecyclerView) findViewById(R.id.recyclerView)).setLayoutManager(l);
       // ((RecyclerView) findViewById(R.id.recyclerView)).addOnItemTouchListener(new Recyc);

        ((RecyclerView) findViewById(R.id.recyclerView)).addOnItemTouchListener(new RecyclerItemClickListener(this, ((RecyclerView) findViewById(R.id.recyclerView)), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // ...

                Toast.makeText(getBaseContext(), "OnItem CLick" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...

                Toast.makeText(getBaseContext(), "OnItem Long..  CLick" , Toast.LENGTH_LONG).show();
            }
        }));
    }
}
