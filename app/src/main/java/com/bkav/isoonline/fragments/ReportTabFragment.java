package com.bkav.isoonline.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bkav.isoonline.R;
import com.bkav.isoonline.adapters.ReportAdapter;
import com.bkav.isoonline.adapters.TroubleAdapter;
import com.bkav.isoonline.models.Report;
import com.bkav.isoonline.models.Report;
import com.bkav.isoonline.models.ReportModel;
import com.bkav.isoonline.models.TroubleModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReportTabFragment extends Fragment {
    private FloatingActionButton fabAdd;
    private RecyclerView mRecyclerViewReport;
    private ReportAdapter mReportAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_fragment, container, false);
        fabAdd = view.findViewById(R.id.fab_add_report);
        mRecyclerViewReport = view.findViewById(R.id.recycler_list_report);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.CENTER);
            }
        });
        mRecyclerViewReport = view.findViewById(R.id.recycler_list_report);
        try {
            mReportAdapter = new ReportAdapter(getListReport());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewReport.setLayoutManager(linearLayoutManager);
        try {
            setAnimation(R.anim.left_to_right);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view;
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_add);
        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams winLayoutParams = window.getAttributes();
        winLayoutParams.gravity = gravity;
        window.setAttributes(winLayoutParams);

        dialog.show();
    }

    private List<Report> getListReport() throws SQLException, ParseException {
        List<Report> Reports = new ArrayList<>();
        ReportModel model = new ReportModel();
        Reports = model.getTroublelist();
        return Reports;
    }
    private void setAnimation(int animResource) throws SQLException, ParseException {
//        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(this, animResource);
//        mRecyclerViewTrouble.setLayoutAnimation(layoutAnimationController);
        mRecyclerViewReport.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        mReportAdapter.setData(getListReport());
        mRecyclerViewReport.setAdapter(mReportAdapter);
    }
}
