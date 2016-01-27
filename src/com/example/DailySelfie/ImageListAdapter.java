package com.example.DailySelfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by ramyashenoy on 1/27/16.
 */
public class ImageListAdapter extends BaseAdapter {

    final int THUMBSIZE = 64;

    List<Selfie> list;
    Context context;
    ViewHolder viewHolder;


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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if(view == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.row_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.selfieThumbnail);
            viewHolder.label = (TextView) view.findViewById(R.id.selfieName);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }


        Selfie selfie = list.get(position);
        Bitmap bitmap = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(selfie.getLabel()),
                THUMBSIZE, THUMBSIZE);
        File file = new File(selfie.getLabel());

        viewHolder.label.setText(file.getName());
        viewHolder.imageView.setImageBitmap(bitmap);
        return view;
    }

    public void setImageItemAtPosition(int position, Bitmap imageSrc, String path) {
        Selfie selfie =  list.get(position);
        selfie.setImage(imageSrc);
        selfie.setLabel(path);
        notifyDataSetChanged();
    }

    static class ViewHolder{
        ImageView imageView;
        TextView label;
    }
}
