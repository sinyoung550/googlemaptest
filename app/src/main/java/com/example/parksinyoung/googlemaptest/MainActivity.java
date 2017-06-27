package com.example.parksinyoung.googlemaptest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SATELLITE = 1;
    public static final int ITEM_NOMAL = 2;
    public static final int ITEM_JIHUNS2 = 3;
    public static final int ITEM_DAEHWI = 4;


    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,ITEM_SATELLITE,0,"위성 지도");
        menu.add(0,ITEM_NOMAL,0,"일반 지도");
        SubMenu hotmenu = menu.addSubMenu("내 남친들^^");
        hotmenu.add(0,ITEM_JIHUNS2,0,"♥지훈이와의 신혼집♥");
        hotmenu.add(0,ITEM_DAEHWI,0,"♥대휘와의 신혼집♥");
//        menu.add(0,ITEM_JIHUNS2,0,"♥지훈이와의 신혼집♥");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case ITEM_SATELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case ITEM_NOMAL: googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case ITEM_JIHUNS2: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.506859, 126.908628),17));
                return true;
            case ITEM_DAEHWI: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.506859, 126.908628),17));
                return true;
        }
        return false;
    }
}