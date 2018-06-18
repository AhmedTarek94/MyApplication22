package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class frag_parts_arab extends Fragment implements View.OnClickListener{

ImageView ar1,ar2;

    public static frag_parts_arab newInstance(int position) {
        frag_parts_arab fragment = new frag_parts_arab();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_parts_arab() {

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
        View view = inflater.inflate(R.layout.frag_parts_arab, container, false);

        ar1=(ImageView)view.findViewById(R.id.ar1);
        ar2=(ImageView)view.findViewById(R.id.ar2);

        ar1.setOnClickListener(this);
        ar2.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case (R.id.ar1):
                String url = "http://www.damascusuniversity.edu.sy/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
               ;

            case (R.id.ar2):
                String url2 = "http://www.iu.edu.sa/";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);
                ;
            default:;
        }

    }
}