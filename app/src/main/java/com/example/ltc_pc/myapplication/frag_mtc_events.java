package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class frag_mtc_events extends Fragment implements View.OnClickListener{


    ImageView ev1,ev2,ev3,ev4;

    public static frag_mtc_events newInstance(int position) {
        frag_mtc_events fragment = new frag_mtc_events();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_mtc_events() {

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
        View view = inflater.inflate(R.layout.frag_mtc_events, container, false);



        ev1=(ImageView)view.findViewById(R.id.ev1);
        ev2=(ImageView)view.findViewById(R.id.ev2);
        ev3=(ImageView)view.findViewById(R.id.ev3);
        ev4=(ImageView)view.findViewById(R.id.ev4);

        ev1.setOnClickListener(this);
        ev2.setOnClickListener(this);
        ev3.setOnClickListener(this);
        ev4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case(R.id.ev1):
                String url3 = "http://www.mtc.edu.eg/Publication/home.aspx?pubid=5";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                ;

            case(R.id.ev2):
                String url = "http://www.mtc.edu.eg/Publication/home.aspx?pubid=6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                ;

            case(R.id.ev3):
                String url31 = "http://www.mtc.edu.eg/Publication/home.aspx?pubid=4";
                Intent i31 = new Intent(Intent.ACTION_VIEW);
                i31.setData(Uri.parse(url31));
                startActivity(i31);
                ;

            case(R.id.ev4):
                String url33 = "http://www.mtc.edu.eg/Publication/home.aspx?pubid=7";
                Intent i33 = new Intent(Intent.ACTION_VIEW);
                i33.setData(Uri.parse(url33));
                startActivity(i33);
                ;
        }
    }
}