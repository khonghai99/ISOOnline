package com.bkav.isoonline.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

            }
        });
        mRecyclerViewReport = view.findViewById(R.id.recycler_list_report);
        mReportAdapter = new ReportAdapter(getListReport());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewReport.setLayoutManager(linearLayoutManager);
        setAnimation(R.anim.left_to_right);
        return view;
    }

    private List<Report> getListReport() {
        List<Report> Reports = new ArrayList<>();
        Reports.add(new Report("Report 1", "Khai1", "1/1/2000"));
        Reports.add(new Report("Report 2", "Khai12", "2/1/2000"));
        Reports.add(new Report("Report 3", "Khai13", "3/1/2000"));
        Reports.add(new Report("Report 4", "Khai14", "4/1/2000"));
        Reports.add(new Report("Report 5", "Khai11", "4/1/2000"));
        Reports.add(new Report("Report 6", "Khai11", "4/1/2000"));
        Reports.add(new Report("Report 7", "Khai12", "4/1/2000"));
        Reports.add(new Report("Report 8", "Khai14", "4/1/2000"));
        Reports.add(new Report("Report 9", "Khai14", "4/1/2000"));
        Reports.add(new Report("Report 10", "Khai14", "4/1/2000"));
        return Reports;
    }
    private void setAnimation(int animResource){
//        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(this, animResource);
//        mRecyclerViewTrouble.setLayoutAnimation(layoutAnimationController);
        mRecyclerViewReport.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        mReportAdapter.setData(getListReport());
        mRecyclerViewReport.setAdapter(mReportAdapter);
    }
}
