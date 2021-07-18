package com.bkav.isoonline.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bkav.isoonline.R;
import com.bkav.isoonline.Session.Golobal;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ResultTabFragment extends Fragment {
    public TextInputEditText Reason;
    public TextInputEditText Solution;
    public TextInputEditText Status;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);
        Reason = view.findViewById(R.id.txtReason);
        Solution = view.findViewById(R.id.txtSolution);
        Status = view.findViewById(R.id.txtStatus);
        String a = Golobal.getReason();
        Reason.setText(a);
        Reason.setFocusable(false);
        String b = Golobal.getSolution();
        Solution.setText(b);
        Solution.setFocusable(false);
        String c = Golobal.getStatus();
        Status.setText(c);
        Status.setFocusable(false);
        return view;
    }
}
