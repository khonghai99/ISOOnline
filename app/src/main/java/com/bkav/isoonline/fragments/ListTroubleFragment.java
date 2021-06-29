package com.bkav.isoonline.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bkav.isoonline.R;
import com.bkav.isoonline.activities.MainActivity;
import com.bkav.isoonline.activities.ViewDetailActivity;
import com.bkav.isoonline.adapters.TroubleAdapter;
import com.bkav.isoonline.models.Trouble;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class ListTroubleFragment extends Fragment implements TroubleAdapter.OnClickTroubleListener{
    private TextInputLayout mLayoutTrouble;
    private AutoCompleteTextView mDropdownTrouble;

    private RecyclerView mRecyclerViewTrouble;
    private TroubleAdapter mTroubleAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_trouble, container, false);
        mLayoutTrouble = (TextInputLayout) view.findViewById(R.id.text_input_layout);
        mDropdownTrouble = (AutoCompleteTextView) view.findViewById(R.id.dropdown_text);

        String[] items = new String[]{
                "Item 1",
                "Item 2",
                "Item 3",
                "Others"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.dropdown_item,
                items
        );
        mDropdownTrouble.setAdapter(adapter);

        mDropdownTrouble.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mRecyclerViewTrouble = view.findViewById(R.id.recycler_list_trouble);
        mTroubleAdapter = new TroubleAdapter(getListTrouble(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewTrouble.setLayoutManager(linearLayoutManager);
        setAnimation(R.anim.left_to_right);
        Log.i("HaiKH", "onCreateView: 1");
        return view;
    }
    
    private List<Trouble> getListTrouble() {
        List<Trouble> troubles = new ArrayList<>();
        troubles.add(new Trouble("trouble 1", "1", "1/1/2000"));
        troubles.add(new Trouble("trouble 2", "2", "2/1/2000"));
        troubles.add(new Trouble("trouble 3", "3", "3/1/2000"));
        troubles.add(new Trouble("trouble 4", "4", "4/1/2000"));
        troubles.add(new Trouble("trouble 5", "1", "4/1/2000"));
        troubles.add(new Trouble("trouble 6", "1", "4/1/2000"));
        troubles.add(new Trouble("trouble 7", "2", "4/1/2000"));
        troubles.add(new Trouble("trouble 8", "4", "4/1/2000"));
        troubles.add(new Trouble("trouble 9", "4", "4/1/2000"));
        troubles.add(new Trouble("trouble 10", "4", "4/1/2000"));
        return troubles;
    }
    private void setAnimation(int animResource){
//        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(this, animResource);
//        mRecyclerViewTrouble.setLayoutAnimation(layoutAnimationController);
        mRecyclerViewTrouble.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        mTroubleAdapter.setData(getListTrouble());
        mRecyclerViewTrouble.setAdapter(mTroubleAdapter);
    }
    @Override
    public void onClickTrouble(int position) {
        openViewDetailFragment();
//        startActivity(new Intent(this, DetailsTrouble.class));
    }

    private void openViewDetailFragment() {
        startActivity(new Intent(getActivity(), ViewDetailActivity.class));
    }
}
