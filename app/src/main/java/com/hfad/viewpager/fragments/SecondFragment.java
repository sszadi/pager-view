package com.hfad.viewpager.fragments;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hfad.viewpager.R;

public class SecondFragment extends Fragment implements OnMapReadyCallback {

    public static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/";
    private static final String API_KEY = "AIzaSyAooUrY64Yqwp7TpxmHgBlj7BMX24HtdVY ";
    private String address = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap googleMap;
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment2_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        try {
            this.googleMap = map;
            LocationManager locationManager;
            locationManager = (LocationManager)
                    getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            Location location = locationManager.getLastKnownLocation(locationManager
                    .getBestProvider(criteria, false));

//            double latitude = location.getLatitude();
            //           double longitude = location.getLongitude();
            LatLng latLng = new LatLng(52, 32);


            map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            map.addMarker(new MarkerOptions().position(latLng).title("Raj Amal"));
            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            ;
        } catch (SecurityException ex) {
            ex.printStackTrace();
            ;
        }
    }

}
