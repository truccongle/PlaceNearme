package com.example.truccongle.searchanything.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truccongle.searchanything.Activity.DiaDiemChiTietActivity;
import com.example.truccongle.searchanything.Model.DiaDiem;
import com.example.truccongle.searchanything.R;
import com.example.truccongle.searchanything.Util.CheckConnection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by truccongle on 11/6/2017.
 */

public class DiaDiemAdapter extends RecyclerView.Adapter<DiaDiemAdapter.ItemHolder> {

    public View view;
    Context context;
    ArrayList<DiaDiem> arrayListDiaDiem;

    public DiaDiemAdapter(Context context, ArrayList<DiaDiem> arrayListDiaDiem) {
        this.context = context;
        this.arrayListDiaDiem = arrayListDiaDiem;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_diadiem_hot, null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        final DiaDiem diaDiem = arrayListDiaDiem.get(position);
        holder.tvTen.setText(diaDiem.getTen());
        Picasso.with(context).load(diaDiem.getHinhAnh())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(holder.imgDiaDiem);
        holder.tvThoiGian.setText("Thời gian"+'\n'+diaDiem.getThoiGian());
        holder.tvDiaChi.setMaxLines(1);
        holder.tvDiaChi.setEllipsize(TextUtils.TruncateAt.END);
        holder.tvDiaChi.setText("Địa chỉ:"+diaDiem.getDiaChi());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DiaDiemChiTietActivity.class);
                intent.putExtra("thongtindiadiem", arrayListDiaDiem.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListDiaDiem.size();
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,DiaDiemChiTietActivity.class);
//                intent.putExtra("thongtindiadiem",arrayListDiaDiem.get(position));
//                start
//
//            }
//        });
//    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgDiaDiem;
        public TextView tvTen, tvThoiGian, tvDiaChi;
        public View view;

        public ItemHolder(View itemView) {
            super(itemView);
            view = itemView;
            imgDiaDiem = (ImageView) itemView.findViewById(R.id.imgDiaDiem);
            tvTen = (TextView) itemView.findViewById(R.id.tvTenDiaDiem);
            tvThoiGian = (TextView) itemView.findViewById(R.id.tvThoiGianDiaDiemHot);
            tvDiaChi = (TextView) itemView.findViewById(R.id.tvDiaChi);



        }

    }
}
