package com.dtrix.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Soumya on 12-06-2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context mcontext=null;
    private int mLayoutResourceid;
    private Place[] mdata =null;

    public PlaceAdapter(Context context, int resource, Place[] objects) {
        super(context, resource, objects);
        this.mcontext=context;
        this.mLayoutResourceid=resource;
        this.mdata=objects;
    }

    @Nullable
    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        //Inflate layout single row
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        row=inflater.inflate(mLayoutResourceid,parent,false);

        //Referance time
        ImageView im=(ImageView)row.findViewById(R.id.imageView);
        TextView tv1 =(TextView)row.findViewById(R.id.textView);
        TextView tv2 =(TextView)row.findViewById(R.id.textView2);

        //get and set data
        Place place = mdata[position];
        tv1.setText(place.getName());
        tv2.setText(String.valueOf(place.getZip()));

        int res=mcontext.getResources().getIdentifier("icon","mipmap",mcontext.getPackageName());
        im.setImageResource(res);

        return row;
    }
}
