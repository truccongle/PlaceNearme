package com.example.truccongle.searchanything.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.truccongle.searchanything.Model.DiaDiem;
import com.example.truccongle.searchanything.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by truccongle on 11/7/2017.
 */

public class QuanAnAdapter extends BaseAdapter {
    Context context;
    ArrayList<DiaDiem> arrayListQuanAn;


    public QuanAnAdapter(Context context, ArrayList<DiaDiem> arrayListQuanAn) {
        this.context = context;
        this.arrayListQuanAn = arrayListQuanAn;
    }

    @Override
    public int getCount() {
        return arrayListQuanAn.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListQuanAn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class  ViewHolder {
        public TextView tvTenQuanAn, tvThoiGian, tvDiaChi;
        public ImageView imgQuanAn;


    }
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_quanan,null);
            viewHolder.tvTenQuanAn=(TextView) convertView.findViewById(R.id.tvTenQuanAn);
            viewHolder.tvThoiGian=(TextView) convertView.findViewById(R.id.tvThoiGianQuanAn);
            viewHolder.tvDiaChi=(TextView) convertView.findViewById(R.id.tvDiaChiQuanAn);
            viewHolder.imgQuanAn=(ImageView) convertView.findViewById(R.id.imgQuanAn);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        DiaDiem diaDiem  = (DiaDiem) getItem(position);
        viewHolder.tvTenQuanAn.setText(diaDiem.getTen());
        viewHolder.tvThoiGian.setText("Thời gian:"+diaDiem.getThoiGian());
        viewHolder.tvDiaChi.setMaxLines(1);
        viewHolder.tvDiaChi.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvDiaChi.setText("Địa chỉ:"+diaDiem.getDiaChi());
        Picasso.with(context).load(diaDiem.getHinhAnh())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgQuanAn);

        return convertView;
    }

}
