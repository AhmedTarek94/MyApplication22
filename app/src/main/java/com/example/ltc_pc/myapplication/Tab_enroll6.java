package com.example.ltc_pc.myapplication;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.provider.Settings;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.UploadTask;


import static android.app.Activity.RESULT_OK;


public class Tab_enroll6 extends Fragment implements View.OnClickListener {

    private Button btn_file;
    private Button btn_submit;
    public static final String STORAGE_PATH_UPLOADS = "uploads/";
    public static final String DATABASE_PATH_UPLOADS = "uploads";
    StorageReference st_ref;
    FirebaseStorage storage;
    FirebaseDatabase database;
    DatabaseReference db_ref;
    final static int PICK_PDF_CODE = 2342;
    ProgressBar progressBar;


    public static frag_parts_mtc newInstance(int position) {
        frag_parts_mtc fragment = new frag_parts_mtc();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);


        return fragment;
    }

    public Tab_enroll6() {

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

        btn_file = (Button) view.findViewById(R.id.btn_file);
        btn_file.setOnClickListener(this);

        btn_submit = (Button) view.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case (R.id.btn_file): {
                showFileChooser();
            }

            case (R.id.btn_submit): {
            }
        }

    }



    private void showFileChooser() {
//permission checking
        String []perm = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED
                ) {
            //request the permission if isn`t granted
            ActivityCompat.requestPermissions(
                    getActivity(), perm, 1000);


             return;
        }//got permission

        //choosing the file
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(
                intent, "PDF"),
                PICK_PDF_CODE);
        /*try {

        }
        //if the user has no file manager
        catch (android.content.ActivityNotFoundException ex) {

            Toast.makeText(getActivity(), "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }*/
        //End of catch





        }//End of file Chooser


    //Checking the return of the chooser
    @Override

    // the intent fileIntent is of type uri
    public void onActivityResult(int requestCode, int resultCode, Intent fileIntent) {
        super.onActivityResult(requestCode, resultCode, fileIntent);

        if (requestCode==PICK_PDF_CODE && requestCode==RESULT_OK
            && fileIntent!=null && fileIntent.getData()!=null)
        {
            //a file is selected
            if(fileIntent.getData()!=null)

               uploadFile(fileIntent.getData());
                }
            else
            {
                Toast.makeText(getActivity(),
                        "No file selected",Toast.LENGTH_LONG)
                        .show();
            }


        }
    //end of file handler

    //File uploading

    private void uploadFile(Uri data)
    {
        progressBar.setVisibility(View.VISIBLE);

        st_ref=storage.getReference();
        st_ref.child("pdf/" + System.currentTimeMillis()+
                ".pdf");
        st_ref.putFile(data)
                .addOnSuccessListener(new OnSuccessListener
                        <UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"Success"
                                ,Toast.LENGTH_LONG);

                    }
                })

                .addOnProgressListener(new OnProgressListener
                        <UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double perc=(100.0*taskSnapshot.
                                getBytesTransferred()
                                /taskSnapshot.getTotalByteCount());
                        Toast.makeText(getContext(),"Transfering"+String.valueOf(perc),
                                Toast.LENGTH_LONG);

                    }
                })


                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(),"Faild"
                                ,Toast.LENGTH_LONG);

                    }
                });



    }

}//End of base class
