package com.example.ltc_pc.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Spinner;


public class frag_conf_papers extends Fragment {


    String [] pap1;
    String [] pap2;
    String [] pap3;
    String [] pap4;


    public static frag_conf_papers newInstance(int position) {
        frag_conf_papers fragment = new frag_conf_papers();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_conf_papers() {

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
        View view = inflater.inflate(R.layout.frag_conf_papers, container, false);

        Button btn_paper=(Button)view.findViewById(R.id.btn_paper);


       final Spinner dep_spin = view.findViewById(R.id.dep_spin);
//create a list of items for the spinner.
        String[] deps = new String[]{"Electrical Engineering", "Mechanical Engineering",
                "Chemical Engineering","Aero-Space Engineering"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        final ArrayAdapter<String> dep_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, deps);
//set the spinners adapter to the previously created one.
        dep_spin.setAdapter(dep_adapter);

        pap1=new String[]{"1","2","3"};
        pap2=new String[]{"12","22","32"};
        pap3=new String[]{"13","23","33"};
        pap4=new String[]{"14","24","34"};

        final Spinner pap_spin = view.findViewById(R.id.pap_spin);
//create a list of items for the spinner.
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        final ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, pap1);
//set the spinners adapter to the previously created one.
        pap_spin.setAdapter(pap_adapter);




        dep_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if (position==0)
                {
                    ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, pap1);
                    pap_spin.setAdapter(pap_adapter);
                    pap_adapter.notifyDataSetChanged();
                }

                else if (position==1)
                {

                    ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, pap2);
                    pap_spin.setAdapter(pap_adapter);
                    pap_adapter.notifyDataSetChanged();
                }

                else if (position==2)
                {
                    ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, pap3);
                    pap_spin.setAdapter(pap_adapter);
                    pap_adapter.notifyDataSetChanged();
                }

                else if (position==3)
                {
                    ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, pap4);
                    pap_spin.setAdapter(pap_adapter);
                    pap_adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        pap_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        return view;


    }


}

