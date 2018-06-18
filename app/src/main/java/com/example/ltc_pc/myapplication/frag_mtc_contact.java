package com.example.ltc_pc.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class frag_mtc_contact extends Fragment{


    TextView txt_site,txt_mail,txt_phone;

    public static frag_mtc_contact newInstance(int position) {
        frag_mtc_contact fragment = new frag_mtc_contact();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public frag_mtc_contact() {

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
        View view = inflater.inflate(R.layout.frag_mtc_contact, container, false);


        txt_site=(TextView)view.findViewById(R.id.txt_site);
        txt_mail=(TextView)view.findViewById(R.id.txt_mail);
        txt_phone=(TextView)view.findViewById(R.id.txt_phone);

        txt_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.mtc.edu.eg";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        txt_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto: info@mtc.edu.eg"));
                startActivity(Intent.createChooser(emailIntent, "Send feedback"));

            }
        });

        txt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] perm = {Manifest.permission.CALL_PHONE};
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        ContextCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED
                        ) {
                    //request the permission if isn`t granted
                    ActivityCompat.requestPermissions(
                            getActivity(), perm, 1000);
                onClick(v);
                }
                            else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0020224036110"));
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}