package com.bkav.isoonline.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bkav.isoonline.R;
import com.bkav.isoonline.models.Report;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<Report> mListReport;

    public ReportAdapter(List<Report> mListReport) {
        this.mListReport = mListReport;
    }

    public void setData(List<Report> reports) {
        this.mListReport = reports;
        notifyDataSetChanged();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameReport;
        private TextView mPeopleReport;
        private TextView mDateCreateReport;
        private TroubleAdapter.OnClickTroubleListener mOnClickTroubleListener;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameReport = itemView.findViewById(R.id.text_name_report);
            mPeopleReport = itemView.findViewById(R.id.text_people_report);
            mDateCreateReport = itemView.findViewById(R.id.text_date_create);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickTroubleListener.onClickTrouble(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report, parent, false);
        return new ReportAdapter.ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report report = mListReport.get(position);
        if (report == null) {
            return;
        }
        holder.mNameReport.setText(report.getContent());
        holder.mPeopleReport.setText(report.getReporterName());
        holder.mDateCreateReport.setText(report.getReportDate());
    }

    @Override
    public int getItemCount() {
        if (mListReport != null) {
            return mListReport.size();
        }
        return 0;
    }
}
