package com.example.truccongle.searchanything.Adapter;

import android.content.Context;
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
 * Created by truccongle on 11/8/2017.
 */

public class KhuVuiChoiAdapter extends BaseAdapter {
    Context context;
    ArrayList<DiaDiem> arrayListKhuVuiChoi;

    public KhuVuiChoiAdapter(Context context, ArrayList<DiaDiem> arrayListKhuVuiChoi) {
        this.context = context;
        this.arrayListKhuVuiChoi = arrayListKhuVuiChoi;
    }

    @Override
    public int getCount() {
        return arrayListKhuVuiChoi.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListKhuVuiChoi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class  ViewHolder {
        public TextView tvTenKhuVuiChoi, tvThoiGian, tvDiaChi;
        public ImageView imgKhuVuiChoi;


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_khuvuichoi,null);
            viewHolder.tvTenKhuVuiChoi=(TextView) convertView.findViewById(R.id.tvTenKhuVuiChoi);
            viewHolder.tvThoiGian=(TextView) convertView.findViewById(R.id.tvThoiGianKhuVuiChoi);
            viewHolder.tvDiaChi=(TextView) convertView.findViewById(R.id.tvDiaChiKhuVuiChoi);
            viewHolder.imgKhuVuiChoi=(ImageView) convertView.findViewById(R.id.imgKhuVuiChoi);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        DiaDiem diaDiem  = (DiaDiem) getItem(position);
        viewHolder.tvTenKhuVuiChoi.setText(diaDiem.getTen());
        viewHolder.tvThoiGian.setText("Thời gian:"+diaDiem.getThoiGian());
        viewHolder.tvDiaChi.setMaxLines(1);
        viewHolder.tvDiaChi.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvDiaChi.setText("Địa chỉ:"+diaDiem.getDiaChi());
        Picasso.with(context).load(diaDiem.getHinhAnh())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgKhuVuiChoi);

        return convertView;
    }
}