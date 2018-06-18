package com.example.ltc_pc.myapplication;

import android.gesture.Gesture;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class frag_mtc_info extends Fragment{

    private ImageView img;
    TextView txt_hist;



    public static frag_mtc_info newInstance(int position) {
        frag_mtc_info fragment = new frag_mtc_info();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_mtc_info() {

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
        View view = inflater.inflate(R.layout.frag_mtc_info, container, false);

        ImageView mtc_header = (ImageView) view.findViewById(R.id.mtc_header);

        txt_hist=view.findViewById(R.id.txt_hist);



        return view;
    }

}