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
    private IOpenDialog mIOpenDialog;

    public ReportAdapter(List<Report> mListReport, IOpenDialog iOpenDialog) {
        this.mListReport = mListReport;
        this.mIOpenDialog = iOpenDialog;
    }

    public void setData(List<Report> reports) {
        this.mListReport = reports;
        notifyDataSetChanged();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameReport;
        private TextView mPeopleReport;
        private TextView mDateCreateReport;
        private IOpenDialog mIOpenDialog;

        public ReportViewHolder(@NonNull View itemView, IOpenDialog iOpenDialog) {
            super(itemView);
            mNameReport = itemView.findViewById(R.id.text_name_report);
            mPeopleReport = itemView.findViewById(R.id.text_people_report);
            mDateCreateReport = itemView.findViewById(R.id.text_date_create);
            this.mIOpenDialog = iOpenDialog;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mIOpenDialog.openDialog(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report, parent, false);
        return new ReportAdapter.ReportViewHolder(view, mIOpenDialog);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report report = mListReport.get(position);
        if (report == null) {
            return;
        }
        holder.mNameReport.setText(report.getmNameReport());
        holder.mPeopleReport.setText(report.getmPeopleReport());
        holder.mDateCreateReport.setText(report.getmDateCreateReport());
    }

    @Override
    public int getItemCount() {
        if (mListReport != null) {
            return mListReport.size();
        }
        return 0;
    }

    public interface IOpenDialog {
        void openDialog(int position);
    }
}
