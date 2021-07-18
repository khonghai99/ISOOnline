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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
        ViewDetailFragment viewDetailFragment = new ViewDetailFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_detail_container, viewDetailFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}