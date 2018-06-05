package com.example.ltc_pc.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
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

        ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        //imageView3.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));

        ImageView imageView4 = (ImageView) view.findViewById(R.id.imageView4);
       // imageView4.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                // Here we can use to full view of image.
            }
        });

        imageView3 .setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Long Clicked", Toast.LENGTH_SHORT).show();
                // Here we can use to show dialog.
                showDialog();
                return true;
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                // Here we can use to full view of image.
            }
        });

        imageView4 .setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Long Clicked", Toast.LENGTH_SHORT).show();
                // Here we can use to show dialog.
                showDialog();
                return true;
            }
        });

        /*SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);*/
        return view;
    }

    public void showDialog(){


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to Like")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       //finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("AlertDialogExample");
        alert.show();

    }

    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }*/
}