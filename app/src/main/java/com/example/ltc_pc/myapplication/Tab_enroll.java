package com.example.ltc_pc.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.EditText;
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


public class Tab_enroll extends Fragment  {

    //Variables
    private Button btn_file, btn_submit;
    private EditText txt_id,txt_name,txt_email,txt_mob;
    private String id;
    private String name;
    private String email;
    private String mob;
    private User user;

    private Uri filePath ;
    String downloadUrl;


    private final int PICK_PDF_REQUEST = 10;


    FirebaseStorage storage;
    StorageReference storageReference;

    FirebaseDatabase database;
    DatabaseReference databaseReference;


    public static frag_parts_mtc newInstance(int position) {
        frag_parts_mtc fragment = new frag_parts_mtc();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);


        return fragment;
    }

    public Tab_enroll() {

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

       storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference("Users");

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();

        txt_id =view.findViewById(R.id.txt_id);
        txt_name=view.findViewById(R.id.txt_name);
        txt_email=view.findViewById(R.id.txt_email);
        txt_mob=view.findViewById(R.id.txt_mob);


        String ids=txt_id.getText().toString();
        name=txt_name.getText().toString();
        email=txt_email.getText().toString();




        btn_file = (Button) view.findViewById(R.id.btn_file);
        btn_submit = (Button) view.findViewById(R.id.btn_submit);

        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){choose();}
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize_user();
                upload();
                push_user();



            }
        });

        return view;
    }



    private void choose() {

        String[] perm = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED
                ) {
            //request the permission if isn`t granted
            ActivityCompat.requestPermissions(
                    getActivity(), perm, 1000);
                        choose();}
        else
            {
            Intent intent = new Intent();
            intent.setType("application/pdf");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PICK_PDF_REQUEST);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();

        }
    }

    private void upload() {

        if (filePath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

           storageReference = storage.getReference().child(filePath.getLastPathSegment().trim().toString());
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            storageReference.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            downloadUrl = String.valueOf(taskSnapshot.getDownloadUrl());
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            Toast.makeText(getContext(), "Uploaded :"+downloadUrl.toString(), Toast.LENGTH_SHORT).show();
                            Clear_fields();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");

                        }
                    });
        }
    }

    public void initialize_user()
    {
        id=txt_id.getText().toString();
        name=txt_name.getText().toString();
        email=txt_email.getText().toString();
        mob=txt_mob.getText().toString();
    }

    private void push_user()
    {


        user=new User(name,id,email,mob);

        databaseReference.child("Users").child(mob).push().setValue(user);

    }

    private void Clear_fields()
    {
        txt_email.setText(null);
        txt_id.setText(null);
        txt_mob.setText(null);
        txt_name.setText(null);
        filePath=null;
    }
}





