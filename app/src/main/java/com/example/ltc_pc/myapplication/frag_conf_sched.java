package com.example.ltc_pc.myapplication;

import android.nfc.FormatException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class frag_conf_sched extends Fragment{

    Button btncmp;
    TextView datecmpres;
    ListView ev_list;
    LinearLayout list_layout;
    public Event[]events=new Event[]{};

    public static frag_conf_sched newInstance(int position) {
        frag_conf_sched fragment = new frag_conf_sched();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_conf_sched() {

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
        View view = inflater.inflate(R.layout.frag_conf_sched, container, false);


        final String exdate="30/6/2018 18:50";
       // datecmpres=(TextView)view.findViewById(R.id.datecmpres);
      //  TextView datestr=(TextView)view.findViewById(R.id.datestr);
        //datestr.setText(new Date().toString());








        //date to string
       /* Date date2=new Date();
        String date_str2=dateFormat.format(date2);*/

        btncmp=(Button)view.findViewById(R.id.btncmp);
        btncmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String to date
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date=new Date();
                try
                {date =dateFormat.parse(exdate);}
                catch (ParseException pe){}

                if (System.currentTimeMillis() >date.getTime())
                {datecmpres.setText("gone");}
                else datecmpres.setText("upcomming");

            }
        });


        return view;
        events[1]=new Event();
    }





}