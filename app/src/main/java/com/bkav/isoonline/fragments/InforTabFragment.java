package com.bkav.isoonline.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bkav.isoonline.R;
import com.google.android.material.textfield.TextInputLayout;

public class InforTabFragment extends Fragment {

    public EditText Receiver;
    public EditText DateReveive;
    public EditText ProblemEmergencyName;
    public EditText CriticalLevelName;
    public EditText ProblemTypeName;
    public EditText ProblemGroupName;
    public EditText Reporter;
    public EditText ContactNumber;
    public EditText ResidentAgencyName;
    public EditText Description;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.infor_fragment, container, false);


        Receiver = view.findViewById(R.id.edit_text_1);
        DateReveive = view.findViewById(R.id.edit_text_2);
        ProblemEmergencyName = view.findViewById(R.id.emergency_txt);
        CriticalLevelName = view.findViewById(R.id.critical_txt);
        ProblemTypeName = view.findViewById(R.id.type_txt);
        ProblemGroupName = view.findViewById(R.id.group_txt);
        Reporter = view.findViewById(R.id.edit_text_3);
        ContactNumber = view.findViewById(R.id.edit_text_4);
        Description = view.findViewById(R.id.edit_text_5);
        ResidentAgencyName = view.findViewById(R.id.edit_text_6);

        Intent myIntent = getActivity().getIntent();
        String a = myIntent.getStringExtra("Name");
        Receiver.setText(a);
        Receiver.setFocusable(false);
        String b = myIntent.getStringExtra("CreatedAt");
        DateReveive.setText(b);
        DateReveive.setFocusable(false);
        String c =myIntent.getStringExtra("Reporter");
        Reporter.setText(c);
        Reporter.setFocusable(false);
        String d =myIntent.getStringExtra("ContactNumber");
        if(d != null){
            ContactNumber.setText(d);
            ContactNumber.setFocusable(false);
        }
        else {
            String e = myIntent.getStringExtra("ReporterEmail");
            if(e != null){
                ContactNumber.setText(e);
                ContactNumber.setFocusable(false);
            }
        }
        String e =myIntent.getStringExtra("ProblemEmergencyName");
        ProblemEmergencyName.setText(e);
        ProblemEmergencyName.setFocusable(false);
        String f =myIntent.getStringExtra("CriticalLevelName");
        CriticalLevelName.setText(f);
        CriticalLevelName.setFocusable(false);
        String g =myIntent.getStringExtra("ProblemTypeName");
        ProblemTypeName.setText(g);
        ProblemTypeName.setFocusable(false);
        String h =myIntent.getStringExtra("ProblemGroupName");
        ProblemGroupName.setText(h);
        ProblemGroupName.setFocusable(false);
        String i = myIntent.getStringExtra("Description");
        Description.setText(i);
        Description.setFocusable(false);
        String j = myIntent.getStringExtra("ResidentAgencyName");
        ResidentAgencyName.setText(j);
        ResidentAgencyName.setFocusable(false);

        return view;
    }
}
