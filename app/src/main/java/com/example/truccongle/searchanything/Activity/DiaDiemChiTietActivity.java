package com.example.truccongle.searchanything.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.truccongle.searchanything.Model.DiaDiem;
import com.example.truccongle.searchanything.R;
import com.example.truccongle.searchanything.Util.CheckConnection;
import com.squareup.picasso.Picasso;

public class DiaDiemChiTietActivity extends AppCompatActivity {
    Toolbar toolbarChiTiet;
    ImageView imageViewChiTiet;
    TextView tvTenChiTiet,tvDiaChiChiTiet,tvThoiGianChiTiet,tvSDT;
    RatingBar ratingBar;
    Button btnXemTrenMap,btnGoiLuon,btnChiaSe,btnTimDuong;
    String GuiTen="";
    String GuiDiaChi="";
    String GuiLatLng="";
    String NumberPhone="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_diem_chi_tiet);
        AnhXa();
        ActionToolbar();
        GetInformation();
        EventButton();
    }

    private void EventButton() {
        btnXemTrenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("ten",GuiTen);
                intent.putExtra("diachi",GuiDiaChi);
                intent.putExtra("latlng",GuiLatLng);
                startActivity(intent);
            }
        });
        btnGoiLuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_DIAL);
                if (NumberPhone.trim().isEmpty()){
                    intent.setData(Uri.parse("tel:0969352676"));
                    CheckConnection.ShowToast_short(getApplicationContext(),"Số điện thoại bị lỗi,Vui lòng liên hệ Admin");
                }else {
                    intent.setData(Uri.parse("tel:"+NumberPhone));
                }
                startActivity(intent);
            }
        });
        btnTimDuong.setOnClickListener(new View.OnClickListener() {
            String MangLatLng = GuiLatLng;
            String[] mangLatLng = MangLatLng.split(",");
            String Lat = mangLatLng[0];
            Double Latitude = Double.parseDouble(Lat);
            String Lng = mangLatLng[1];
            Double Longitude = Double.parseDouble(Lng);
            @Override
            public void onClick(View v) {
                String chiduong="google.navigation:q="+Latitude+","+Longitude;
                Uri uri=Uri.parse(chiduong);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });
        btnChiaSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="Cảm ơn bạn đã sử dụng app";
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plan");
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                intent.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.app_name));
                intent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(intent,"Share Content with..."));
            }
        });
    }

    private void GetInformation() {
        float Rating=0;
        int MaChiTiet=0;
        String TenDiaDiemChiTiet="";
        String HinhAnhChiTiet="";
        String DiaChiChiTiet="";
        String ThoiGianChiTiet="";
        String SDTChiTiet="";
        String DanhGiaChiTiet="";
        String LatLng="";
        int IdLoaiDiaDiem=0;;
        DiaDiem diaDiem= (DiaDiem) getIntent().getSerializableExtra("thongtindiadiem");
        MaChiTiet= diaDiem.getMa();
        TenDiaDiemChiTiet=diaDiem.getTen();
        HinhAnhChiTiet=diaDiem.getHinhAnh();
        DiaChiChiTiet=diaDiem.getDiaChi();
        ThoiGianChiTiet=diaDiem.getThoiGian();
        SDTChiTiet=diaDiem.getSDT();
        DanhGiaChiTiet=diaDiem.getDanhGia();
        LatLng=diaDiem.getLatLng();
        IdLoaiDiaDiem=diaDiem.getIdLoaiDiaDiem();
        tvTenChiTiet.setText(TenDiaDiemChiTiet);
        Rating=(Float.parseFloat(DanhGiaChiTiet));
        ratingBar.setNumStars((int) Rating);
        tvThoiGianChiTiet.setText("- Thời gian:"+ThoiGianChiTiet);
        tvDiaChiChiTiet.setText("- Địa chỉ:\n  "+DiaChiChiTiet);
        tvSDT.setText("- Số điện thoại:"+SDTChiTiet);
        Picasso.with(getApplicationContext()).load(HinhAnhChiTiet)
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_error)
                .into(imageViewChiTiet);
        GuiTen=TenDiaDiemChiTiet;
        GuiDiaChi=DiaChiChiTiet;
        GuiLatLng=LatLng;
        NumberPhone=SDTChiTiet;



    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void AnhXa() {
        toolbarChiTiet=(Toolbar) findViewById(R.id.toolbarThongTinDiaDiem);
        imageViewChiTiet=(ImageView) findViewById(R.id.imgThongTinDiaDiem);
        tvTenChiTiet=(TextView)findViewById(R.id.tvTenDiaDiemChiTiet);
        tvThoiGianChiTiet=(TextView)findViewById(R.id.tvThoiGianChiTiet);
        tvSDT=(TextView)findViewById(R.id.tvSDTChiTiet);
        tvDiaChiChiTiet=(TextView)findViewById(R.id.tvDiaChiChiTiet);
        ratingBar=(RatingBar) findViewById(R.id.ratingbar);
        btnXemTrenMap=(Button)findViewById(R.id.btnXemTrenMap);
        btnGoiLuon=(Button)findViewById(R.id.btnGoiLuon);
        btnTimDuong=(Button)findViewById(R.id.btnTimDuong);
        btnChiaSe=(Button)findViewById(R.id.btnChiaSe);
    }

}
