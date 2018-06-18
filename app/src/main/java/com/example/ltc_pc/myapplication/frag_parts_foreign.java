package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class frag_parts_foreign extends Fragment implements View.OnClickListener{


    ImageView fr1,fr2,fr3,fr4;

    public static frag_parts_foreign newInstance(int position) {
        frag_parts_foreign fragment = new frag_parts_foreign();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_parts_foreign() {

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
        View view = inflater.inflate(R.layout.frag_parts_foriegn, container, false);

        fr1=(ImageView)view.findViewById(R.id.fr1);
        fr2=(ImageView)view.findViewById(R.id.fr2);
        fr3=(ImageView)view.findViewById(R.id.fr3);
        fr4=(ImageView)view.findViewById(R.id.fr4);

        fr1.setOnClickListener(this);
        fr2.setOnClickListener(this);
        fr3.setOnClickListener(this);
        fr4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case (R.id.fr1):
                String url = "https://www.ugent.be/en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                ;
            case (R.id.fr2):
                String url2 = "https://www.uottawa.ca/en";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);
                ;
            case (R.id.fr3):
                String url3 = "http://www.uwindsor.ca/";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                ;

            case (R.id.fr4):
                String url4 = "https://unilag.edu.ng/";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                ;

            default:;
        }

    }
}