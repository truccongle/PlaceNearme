package com.example.truccongle.searchanything.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.truccongle.searchanything.Adapter.DiaDiemAdapter;
import com.example.truccongle.searchanything.Adapter.LoaiDiaDiemAdapter;
import com.example.truccongle.searchanything.Model.DiaDiem;
import com.example.truccongle.searchanything.Model.LoaiDiaDiem;
import com.example.truccongle.searchanything.R;
import com.example.truccongle.searchanything.Util.CheckConnection;
import com.example.truccongle.searchanything.Util.Server;
import com.example.truccongle.searchanything.Util.VerifyPermissions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<LoaiDiaDiem> mangLoaiDiaDiem;
    LoaiDiaDiemAdapter loaiDiaDiemAdpapter;
    int id;
    String loai = "";
    String hinhanh = "";
    ArrayList<DiaDiem> mangDiaDiem;
    DiaDiemAdapter diaDiemAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            ActionBar();
            ActionViewFlipper();
            GetDuLieuDiaDiem();
            GetDuLieuDiaDiemHot();
            CathOnItemListView();



        } else {
            CheckConnection.ShowToast_short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
            finish();
        }
    }


    private void CathOnItemListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, QuanAnActivity.class);
                            intent.putExtra("idloaidiadiem", mangLoaiDiaDiem.get(position).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, QuanNuocActivity.class);
                            intent.putExtra("idloaidiadiem", mangLoaiDiaDiem.get(position).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, KhuVuiChoiActivity.class);
                            intent.putExtra("idloaidiadiem", mangLoaiDiaDiem.get(position).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);

                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, LienHeActivity.class);

                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void GetDuLieuDiaDiemHot() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.URLDiaDiemHot, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int Ma = 0;
                    String Ten = "";
                    String HinhAnh = "";
                    String DiaChi = "";
                    String ThoiGiam = "";
                    String SDT = "";
                    String DanhGia = "";
                    String LatLng = "";
                    int IdLoaiDiaDiem = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            Ma = jsonObject.getInt("ma");
                            Ten = jsonObject.getString("ten");
                            HinhAnh = jsonObject.getString("hinhanh");
                            DiaChi = jsonObject.getString("diachi");
                            ThoiGiam = jsonObject.getString("thoigian");
                            SDT = jsonObject.getString("sdt");
                            DanhGia = jsonObject.getString("danhgia");
                            LatLng = jsonObject.getString("latlng");
                            IdLoaiDiaDiem = jsonObject.getInt("idloaidiadiem");
                            mangDiaDiem.add(new DiaDiem(Ma, Ten, HinhAnh, DiaChi, ThoiGiam, SDT, DanhGia, LatLng, IdLoaiDiaDiem));
                            diaDiemAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_short(getApplicationContext(), "Kiểm tra lại kết nối");

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuDiaDiem() {
        final RequestQueue requestQuee = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.URLLoaiDiaDiem, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (requestQuee != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            loai = jsonObject.getString("loai");
                            hinhanh = jsonObject.getString("hinhanh");
                            mangLoaiDiaDiem.add(new LoaiDiaDiem(id, loai, hinhanh));
                            loaiDiaDiemAdpapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangLoaiDiaDiem.add(4, new LoaiDiaDiem(0, "Thông Tin", "http://www.stmivani.eu/gallery/info_icon.png"));
                    mangLoaiDiaDiem.add(5, new LoaiDiaDiem(0, "Liên Hệ", "https://lh3.googleusercontent.com/2HCCRi_TAF2arEs8-oSOPHX878zUOLDTNmidbJyM0NuVHS-Vh2nxU3ZJ6SGAUtabQ2g=w100"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_short(getApplicationContext(), error.toString());
            }
        });
        requestQuee.add(jsonArrayRequest);
    }


    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://scontent.fhph1-2.fna.fbcdn.net/v/t1.0-9/23316523_769394469935301_5821119336647753818_n.jpg?oh=86067a63ea2e66a899db63de754b46d5&oe=5A692E88");
        mangquangcao.add("https://scontent.fhph1-2.fna.fbcdn.net/v/t1.0-9/23319030_769394466601968_5093232030380220936_n.jpg?oh=d2eec1fa833a7471f0d9848d2bf1c86e&oe=5A687AEA");
        mangquangcao.add("https://scontent.fhph1-2.fna.fbcdn.net/v/t1.0-9/23319449_769395116601903_2565248430285612513_n.jpg?oh=21d721b9bacdcb50ee2f51bf93b6a0ed&oe=5A6B34E2");
        mangquangcao.add("https://scontent.fhph1-2.fna.fbcdn.net/v/t1.0-9/23319449_769395116601903_2565248430285612513_n.jpg?oh=21d721b9bacdcb50ee2f51bf93b6a0ed&oe=5A6B34E2");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation ani_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation ani_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(ani_slide_in);
        viewFlipper.setOutAnimation(ani_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        navigationView = (NavigationView) findViewById(R.id.navitionview);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        listView = (ListView) findViewById(R.id.listview);
        mangLoaiDiaDiem = new ArrayList<>();
        mangLoaiDiaDiem.add(0, new LoaiDiaDiem(0, "Trang chủ", "http://domofonru.com/templates/blue/images/logo.png"));
        loaiDiaDiemAdpapter = new LoaiDiaDiemAdapter(mangLoaiDiaDiem, getApplicationContext());
        listView.setAdapter(loaiDiaDiemAdpapter);
        mangDiaDiem = new ArrayList<>();
        diaDiemAdapter = new DiaDiemAdapter(this, mangDiaDiem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(diaDiemAdapter);
    }




}
