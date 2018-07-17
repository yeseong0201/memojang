package com.example.ys020.memojang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflate;
    private List<MyModel> mData;

    public MyAdapter(ArrayList<MyModel> data, Context context) {
        mData = data;
        mContext = context;
        mInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public MyModel getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listitem,null);
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = mInflate.inflate(R.layout.activity_listitem, parent, false);
            TextView title = (TextView) convertView.findViewById(R.id.title_txt);
            TextView contetnt = (TextView) convertView.findViewById(R.id.content_txt);
            holder.title = title;
            holder.content = contetnt;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MyModel model = getItem(position);
        holder.title.setText(model.getTitle());
        holder.content.setText(model.getContent());

        return v;
    }

    class ViewHolder {
        TextView title;
        TextView content;
    }
}
