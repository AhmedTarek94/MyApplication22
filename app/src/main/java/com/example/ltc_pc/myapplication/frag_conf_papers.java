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

    String []dep_pap;
    Button btn_paper;
    String url;


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

        btn_paper=(Button)view.findViewById(R.id.btn_paper);
        dep_pap=new String[]{"https://drive.google.com/open?id=1Glq0Ede9KKStaEQDiI9Lrc1VfTFeWXUB",
                             "https://drive.google.com/open?id=1hWA3qxk_8f61K9YiouFUVZhyIbO93D6p"};


       final Spinner dep_spin = view.findViewById(R.id.dep_spin);
//create a list of items for the spinner.
        String[] deps = new String[]{"Electrical Engineering", "Mechanical Engineering",
                "Chemical Engineering","Aero-Space Engineering",
                "Naval Engineering","Civil and Architectural Engineering"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        final ArrayAdapter<String> dep_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, deps);
//set the spinners adapter to the previously created one.
        dep_spin.setAdapter(dep_adapter);

        pap1=new String[]{"paper 1","paper 2","paper 3"};
        pap2=new String[]{"paper 12","paper 22","paper 32"};
        pap3=new String[]{"paper 13","paper 23","paper 33"};
        pap4=new String[]{"paper 14","paper 24","paper 34"};

        final Spinner pap_spin = view.findViewById(R.id.pap_spin);
//create a list of items for the spinner.
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        final ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, pap1);

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

                else if (position==4)
                {
                    ArrayAdapter<String> pap_adapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, pap4);
                    pap_spin.setAdapter(pap_adapter);
                    pap_adapter.notifyDataSetChanged();
                }

                else if (position==5)
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
                /*if(position==0)
                {
                   url=dep_pap[0];
                }
                else if(position==1)
                {

                }*/

                url=dep_pap[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent=new Intent(getActivity(),viewer.class);
                view_intent.putExtra("url",url);
                startActivity(view_intent);
                getActivity().overridePendingTransition(R.anim.leave,R.anim.leave);
            }
        });


        return view;


    }


}

