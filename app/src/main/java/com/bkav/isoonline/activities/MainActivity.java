package com.bkav.isoonline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bkav.isoonline.R;
import com.bkav.isoonline.adapters.TroubleAdapter;
import com.bkav.isoonline.fragments.ListTroubleFragment;
import com.bkav.isoonline.fragments.ViewDetailFragment;
import com.bkav.isoonline.models.Trouble;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListTroubleFragment listTroubleFragment = new ListTroubleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, listTroubleFragment).commit();
    }
}