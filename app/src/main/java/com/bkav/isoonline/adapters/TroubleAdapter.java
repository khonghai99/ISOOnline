package com.bkav.isoonline.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bkav.isoonline.R;
import com.bkav.isoonline.models.Trouble;

import java.util.List;

public class TroubleAdapter extends RecyclerView.Adapter<TroubleAdapter.TroubleViewHolder> {

    private List<Trouble> mListTrouble;
    private OnClickTroubleListener mOnClickTroubleListener;

    public TroubleAdapter(List<Trouble> mListTrouble, OnClickTroubleListener mOnClickTroubleListener) {
        this.mListTrouble = mListTrouble;
        this.mOnClickTroubleListener = mOnClickTroubleListener;
    }

    public void setData(List<Trouble> troubles){
        this.mListTrouble = troubles;
        notifyDataSetChanged();
    }

    public class TroubleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTextNameTrouble;
        private TextView mTextLevel;
        private TextView mTextDate;
        private OnClickTroubleListener mOnClickTroubleListener;

        public TroubleViewHolder(@NonNull View itemView, OnClickTroubleListener onClickTroubleListener) {
            super(itemView);
            mTextNameTrouble = itemView.findViewById(R.id.text_name_trouble);
            mTextLevel = itemView.findViewById(R.id.text_value_level);
            mTextDate = itemView.findViewById(R.id.text_date_create);
            this.mOnClickTroubleListener = onClickTroubleListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickTroubleListener.onClickTrouble(getAdapterPosition());
        }
    }

    public interface OnClickTroubleListener {
        void onClickTrouble(int position);
    }

    @NonNull
    @Override
    public TroubleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trouble, parent, false);
        return new TroubleViewHolder(view, mOnClickTroubleListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TroubleViewHolder holder, int position) {
        Trouble trouble = mListTrouble.get(position);
        if (trouble == null){
            return;
        }
        holder.mTextNameTrouble.setText(trouble.getNameTrouble());
        holder.mTextLevel.setText(trouble.getLevel());
        holder.mTextDate.setText(trouble.getDate());
    }

    @Override
    public int getItemCount() {
        if (mListTrouble != null){
            return mListTrouble.size();
        }
        return 0;
    }
}
