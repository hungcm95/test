package com.nl.learn_android_bt1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter {
    Context context;
    ArrayList<User> users=new ArrayList<>();
    LayoutInflater inflater;
    int resource;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> users) {
        super(context, resource, users);
        this.context=context;
        this.resource=resource;
        this.users=users;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(resource,parent,false);
        }
        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvPhone=convertView.findViewById(R.id.tvPhone);
        tvName.setText(users.get(position).getName());
        tvPhone.setText(users.get(position).getPhone());
        return convertView;
    }
}
