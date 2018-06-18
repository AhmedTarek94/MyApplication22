package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class frag_parts_egy extends Fragment implements View.OnClickListener {

ImageView eg1,eg2,eg3,eg4;

    public static frag_parts_egy newInstance(int position) {
        frag_parts_egy fragment = new frag_parts_egy();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_parts_egy() {

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
        View view = inflater.inflate(R.layout.frag_parts_egy, container, false);

        eg1=(ImageView)view.findViewById(R.id.eg1);
        eg2=(ImageView)view.findViewById(R.id.eg2);
        eg3=(ImageView)view.findViewById(R.id.eg3);
        eg4=(ImageView)view.findViewById(R.id.eg4);

        eg1.setOnClickListener(this);
        eg2.setOnClickListener(this);
        eg3.setOnClickListener(this);
        eg4.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case (R.id.eg1):
                String url = "http://www.tanta.edu.eg/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                ;

            case (R.id.eg2):
                String url2 = "http://www.zu.edu.eg/";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);

            case (R.id.eg3):
                String url3 = "http://www.modern-academy.edu.eg/";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                ;

            case (R.id.eg4):
                String url4 = "http://www.mans.edu.eg/";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                ;
            case (R.id.eg5):
                String url5 = "http://www.asu.edu.eg/arabic/";
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse(url5));
                startActivity(i5);
                ;
            default:;
        }

    }
}