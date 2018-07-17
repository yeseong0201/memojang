package com.example.ys020.memojang;

import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Data;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView setTitle,setContent;
    ListView mListView;
    MyAdapter mMyAdapter;

    MyModel mModel;
    ArrayList<MyModel> items = new ArrayList<>();
    FloatingActionButton mFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel = new MyModel();
        mModel.setTitle("title");
        mModel.setContent("content");
        mMyAdapter = new MyAdapter(items,);
        mMyAdapter.(mModel);
        mFab = (FloatingActionButton) findViewById(R.id.floating_action_btn);
        mFab.setOnClickListener(this);
        mMyAdapter = new MyAdapter(mMyAdapter,getApplicationContext());
        mListView = (ListView) findViewById(R.id.main_list_view);
        mListView.setAdapter(mMyAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 || data !=null){
            mModel = new MyModel();
            mModel.setTitle(data.getStringExtra("title"));
            mModel.setContent(data.getStringExtra("content"));

            mMyAdapter.notifyDataSetChanged();
    }
}
}
