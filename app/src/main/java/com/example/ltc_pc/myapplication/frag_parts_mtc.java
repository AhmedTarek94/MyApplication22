package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class frag_parts_mtc extends Fragment implements View.OnClickListener{


    ImageView de1,de2,de3,de4,de5;

    public static frag_parts_mtc newInstance(int position) {
        frag_parts_mtc fragment = new frag_parts_mtc();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_parts_mtc() {

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
        View view = inflater.inflate(R.layout.frag_parts_mtc, container, false);

        de1=(ImageView)view.findViewById(R.id.de1);
        de2=(ImageView)view.findViewById(R.id.de2);
        de3=(ImageView)view.findViewById(R.id.de3);
        de4=(ImageView)view.findViewById(R.id.de4);
        de5=(ImageView)view.findViewById(R.id.de5);

        de1.setOnClickListener(this);
        de2.setOnClickListener(this);
        de3.setOnClickListener(this);
        de4.setOnClickListener(this);
        de5.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case (R.id.eg1):
                String url = "http://www.mtc.edu.eg/mtcwebsite/Branch.aspx?id=1";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                ;

            case (R.id.eg2):
                String url2 = "http://www.mtc.edu.eg/mtcwebsite/Branch.aspx?id=2";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);

            case (R.id.eg3):
                String url3 = "http://www.mtc.edu.eg/mtcwebsite/Branch.aspx?id=3";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                ;

            case (R.id.eg4):
                String url4 = "http://www.mtc.edu.eg/mtcwebsite/Branch.aspx?id=6";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                ;
            case (R.id.eg5):
                String url5 = "http://www.mtc.edu.eg/mtcwebsite/Branch.aspx?id=4";
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse(url5));
                startActivity(i5);
                ;
            default:;
        }


    }
}