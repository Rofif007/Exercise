package com.example.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class List_View extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;

    private ArrayList<ClassNama> arrayList;

    public List_View(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    public List_View(Home_Activity homeActivity) {

    }

    public class ViewHolder {
        TextView name;
    }


    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if ( view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_list__view,null);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());
        return view;

    }


}