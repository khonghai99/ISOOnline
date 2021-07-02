package com.bkav.isoonline.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.bkav.isoonline.R;
import com.bkav.isoonline.fragments.ListTroubleFragment;
import com.bkav.isoonline.fragments.ViewDetailFragment;
import com.google.android.material.textfield.TextInputLayout;

public class ViewDetailActivity extends AppCompatActivity {

    public EditText Receiver;
    public EditText DateReveive;
    public TextInputLayout ProblemEmergencyName;
    public TextInputLayout CriticalLevelName;
    public TextInputLayout ProblemTypeName;
    public TextInputLayout ProblemGroupName;
    public EditText Reporter;
    public EditText ContactNumber;
    public EditText ResidentAgencyName;
    public EditText Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
        ViewDetailFragment viewDetailFragment = new ViewDetailFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_detail_container, viewDetailFragment).commit();


        Receiver = findViewById(R.id.edit_text_1);
        DateReveive = findViewById(R.id.edit_text_2);
        ProblemEmergencyName =findViewById(R.id.text_input_layout_3);
        CriticalLevelName =findViewById(R.id.text_input_layout_4);
        ProblemTypeName =findViewById(R.id.text_input_layout_5);
        ProblemGroupName =findViewById(R.id.text_input_layout_6);
        Reporter = findViewById(R.id.edit_text_3);
        ContactNumber = findViewById(R.id.edit_text_4);
        Description = findViewById(R.id.edit_text_5);
        ResidentAgencyName = findViewById(R.id.edit_text_6);

        Intent myIntent = getIntent();
        String a = myIntent.getStringExtra("Name");
        Receiver.setText(a);
        String b = myIntent.getStringExtra("CreatedAt");
        DateReveive.setText(b);
        String c =myIntent.getStringExtra("Reporter");
        Reporter.setText(c);
        String d =myIntent.getStringExtra("ContactNumber");
        if(d != null){
            ContactNumber.setText(d);
        }
        else {
            String e = myIntent.getStringExtra("ReporterEmail");
            if(e != null){
                ContactNumber.setText(e);
            }
        }

        String f = myIntent.getStringExtra("Description");
        Description.setText(f);
        String g = myIntent.getStringExtra("ResidentAgencyName");
        ResidentAgencyName.setText(g);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}