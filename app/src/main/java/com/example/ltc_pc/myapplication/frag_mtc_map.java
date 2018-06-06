package com.example.ltc_pc.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;



/*
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
*/

public class frag_mtc_map extends Fragment /*implements OnMapReadyCallback  */{

  /*  private GoogleMap mMap;*/


    public static frag_mtc_map newInstance(int position) {
        frag_mtc_map fragment = new frag_mtc_map();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_mtc_map() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {


           /* mPosition = getArguments().getInt("position");*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_mtc_map, container, false);


        PhotoView photo_map1 = (PhotoView) view.findViewById(R.id.photo_map1);
       // photo_map1.setImageResource(R.drawable.map1);

        PhotoView photo_map2 = (PhotoView) view.findViewById(R.id.photo_map2);
        //photo_map2.setImageResource(R.drawable.map2);

        Button btn_find=(Button)view.findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:30.080448,31.296269?z=20");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


       // final ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        //imageView3.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));V



        ImageView imageView4 = (ImageView) view.findViewById(R.id.imageView4);
       // imageView4.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));





        /*SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);*/
        return view;
    }



}