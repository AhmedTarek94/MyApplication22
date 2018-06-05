package com.example.ltc_pc.myapplication;

import android.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;

import static android.app.Activity.RESULT_OK;

public class Tab_enroll2 extends Fragment {

    private Button btn_file,btn_submit;
    private StorageReference storageReference;
    public Uri uri;
    private ProgressDialog progressDialog;

    public static frag_parts_mtc newInstance(int position) {
        frag_parts_mtc fragment = new frag_parts_mtc();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);



        return fragment;
    }

    public Tab_enroll2() {

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

        View view = inflater.inflate(R.layout.tab_enroll, container, false);

        storageReference= FirebaseStorage.getInstance().getReference();
        progressDialog=new ProgressDialog(getContext());

        btn_file=(Button)view.findViewById(R.id.btn_file);
        btn_submit=(Button)view.findViewById(R.id.btn_submit);
        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String []perm = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        ContextCompat.checkSelfPermission(getActivity(),
                                android.Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED
                        ) {
                    //request the permission if isn`t granted
                    ActivityCompat.requestPermissions(
                            getActivity(), perm, 1000);

                }

                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");

                startActivityForResult(Intent.createChooser(intent,"get pdf"),2);




                    return;
                }




        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StorageReference filepath=storageReference
                        .child("pdf").child(uri.getLastPathSegment());
                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(),
                                "done",Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();

                        Toast.makeText(getContext(),
                                "failed",Toast.LENGTH_LONG).show();
                    }
                })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                progressDialog.setMessage("Uploading");
                            }
                        });

            }
        });


        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2&& requestCode==RESULT_OK)
        {

            uri=data.getData();
            if (uri==null)
            {
                Toast.makeText(getContext(),"null reference",Toast.LENGTH_LONG).show();

            }
            Toast.makeText(getContext(),uri.toString(),Toast.LENGTH_LONG).show();

        }

    }
}