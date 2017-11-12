package com.example.truccongle.searchanything.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truccongle.searchanything.Model.DiaDiem;
import com.example.truccongle.searchanything.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by truccongle on 11/7/2017.
 */

public class QuanNuocAdapter extends BaseAdapter {
    Context context;
    ArrayList<DiaDiem> arrayListQuanNuoc;

    public QuanNuocAdapter(Context context, ArrayList<DiaDiem> arrayListQuanNuoc) {
        this.context = context;
        this.arrayListQuanNuoc = arrayListQuanNuoc;
    }

    @Override
    public int getCount() {
        return arrayListQuanNuoc.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListQuanNuoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class  ViewHolder {
        public TextView tvTenQuanNuoc, tvThoiGian, tvDiaChi;
        public ImageView imgQuanNuoc;


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_quannuoc,null);
            viewHolder.tvTenQuanNuoc=(TextView) convertView.findViewById(R.id.tvTenQuanNuoc);
            viewHolder.tvThoiGian=(TextView) convertView.findViewById(R.id.tvThoiGianQuanNuoc);
            viewHolder.tvDiaChi=(TextView) convertView.findViewById(R.id.tvDiaChiQuanNuoc);
            viewHolder.imgQuanNuoc=(ImageView) convertView.findViewById(R.id.imgQuanNuoc);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        DiaDiem diaDiem  = (DiaDiem) getItem(position);
        viewHolder.tvTenQuanNuoc.setText(diaDiem.getTen());
        viewHolder.tvThoiGian.setText("Thời gian:"+diaDiem.getThoiGian());
        viewHolder.tvDiaChi.setMaxLines(1);
        viewHolder.tvDiaChi.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvDiaChi.setText("Địa chỉ:"+diaDiem.getDiaChi());
        Picasso.with(context).load(diaDiem.getHinhAnh())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgQuanNuoc);

        return convertView;
    }
}
