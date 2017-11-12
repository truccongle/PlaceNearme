package com.example.truccongle.searchanything.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truccongle.searchanything.Model.LoaiDiaDiem;
import com.example.truccongle.searchanything.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by truccongle on 11/5/2017.
 */

public class LoaiDiaDiemAdapter  extends BaseAdapter{
    ArrayList<LoaiDiaDiem> arrayListLoaiDiaDiem;
    Context context;

    public LoaiDiaDiemAdapter(ArrayList<LoaiDiaDiem> arrayListLoaiDiaDiem, Context context) {
        this.arrayListLoaiDiaDiem = arrayListLoaiDiaDiem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaiDiaDiem.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListLoaiDiaDiem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public  class  ViewHolder{
        TextView tvLoaiDiaDiem;
        ImageView imgLoaiDiaDiem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView ==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.dong_lv_loaidiadiem,null);
            viewHolder.tvLoaiDiaDiem= (TextView) convertView.findViewById(R.id.tvLoaiDiaDiem);
            viewHolder.imgLoaiDiaDiem=(ImageView)convertView.findViewById(R.id.imgLoaiDiaDiem);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        LoaiDiaDiem loaiDiaDiem=(LoaiDiaDiem) getItem(position);
        viewHolder.tvLoaiDiaDiem.setText(loaiDiaDiem.getLoai());
        Picasso.with(context).load(loaiDiaDiem.getHinhanh())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgLoaiDiaDiem);
        return convertView;
    }
}
