package com.example.DailySelfie;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ramyashenoy on 1/27/16.
 */
public class ImageListAdapter extends BaseAdapter {


    List<Selfie> list;
    Context context;
    ViewHolder view;


    public ImageListAdapter(List<Selfie> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    static class ViewHolder{
        ImageView imageView;
        String label;
    }
}
