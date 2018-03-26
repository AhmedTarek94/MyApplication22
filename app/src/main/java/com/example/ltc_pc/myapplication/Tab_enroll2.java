package com.example.ltc_pc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.util.regex.Pattern;

import static android.app.Activity.RESULT_OK;

public class Tab_enroll2 extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private  FirebaseDatabase database;
    DatabaseReference users;

    private Spinner spinner;
    private static final String[]paths = {"University : ","Cairo", "Tanta", "MTC"};

    private double uni=0;

    private TextView txt_name;
    private TextView txt_email;
    private TextView txt_mob;
    private String file=null;


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


        Button btn_submit=(Button)view.findViewById(R.id.btn_submit);
        Button btn_file=(Button)view.findViewById(R.id.btn_file);
        btn_submit.setOnClickListener(this);
        btn_file.setOnClickListener(this);

         database = FirebaseDatabase.getInstance();

         users = database.getReference("Users:");
        //this code for keep posts even app offline until the app online again
        users.keepSynced(true);

        spinner = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

/*User (String name,String email,int id,int mob,int univ)*/

        switch (view.getId()) {
            case (R.id.btn_submit): {
                //Upload




                //Submit User

                //users.push().setValue(u1);


                Toast.makeText(getActivity(),"Done",Toast.LENGTH_LONG).show();
            }

            case (R.id.btn_file):
                    {
                        getFile();

                    }
            default:break;

        }

    }

    private void getFile()
    {

        new MaterialFilePicker()
                .withActivity(getActivity())
                .withRequestCode(1000)
                .withFilter(Pattern.compile(".*\\.pdf$")) // Filtering files and directories by file name using regexp
                .withFilterDirectories(true) // Set directories filterable (false by default)
                .withHiddenFiles(true) // Show hidden files and folders
                .start();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            file = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            // Do anything with file
        }
    }


//University selection
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;

            default:break;

    }


}

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }}

