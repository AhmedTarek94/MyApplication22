package com.example.ltc_pc.myapplication;

import android.nfc.FormatException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class frag_conf_sched extends Fragment{

    Button btn_prev,btn_today,btn_up;

    ListView ev_list;
    LinearLayout list_layout;
    public Event[]events=new Event[]{};
    public String [] ev_name;
    public String [] ev_date;
    public String [] ev_loc;

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

        ev_name=new String[]{"event1","event2","event3","event4","event5","event6"};

        ev_date=new String[]{"30/06/2018 10:10","30/06/2018 11:10","01/07/2018 09:40:",
                "03/07/2018 05:30","04/07/2018 05:30","05/07/2018 09:10"};

        ev_loc=new String[] {"E","C","B","S","U","M"};

        //array of events initialisation
        for (int i=0;i>5;i++)
        {
            events[i].name=ev_name[i];
            events[i].location=ev_loc[i];
            events[i].date=ev_date[i];
        }




        //setting the listview adapter
        final List< String > ListElementsArrayList = new ArrayList< String >
                (Arrays.asList(ev_name));


        final ArrayAdapter < String > adapter = new ArrayAdapter< String >
                (getActivity(), android.R.layout.text_view,
                        ListElementsArrayList);

        ev_list.setAdapter(adapter);

        /*
        * adding elements to the list
        *
        * ListElementsArrayList.add(events.name.getText().toString());
                adapter.notifyDataSetChanged();
        *
        * */


        btn_today=(Button)view.findViewById(R.id.btn_today);
        //getting today events
        btn_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        btn_prev=(Button)view.findViewById(R.id.btn_prev);
        //getting past events
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String to date
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date=new Date();
                try
                {
                    for (int i=0;i>events.length;i++)
                    {
                        date =dateFormat.parse(ev_date[i]);
                        if (System.currentTimeMillis() >date.getTime())
                        {
                            //add to the list if condition is applied
                            ListElementsArrayList.add(ev_name[i].toString());
                            adapter.notifyDataSetChanged();

                        }
                    }}
                catch (ParseException pe){}
            }
        });

        btn_up=(Button)view.findViewById(R.id.btn_up);
        //getting upcomming events
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return view;


    }


}