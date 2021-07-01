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
import com.bkav.isoonline.Session.Golobal;
import com.bkav.isoonline.activities.MainActivity;
import com.bkav.isoonline.activities.ViewDetailActivity;
import com.bkav.isoonline.adapters.TroubleAdapter;
import com.bkav.isoonline.models.Trouble;
import com.bkav.isoonline.models.TroubleModel;
import com.bkav.isoonline.models.User;
import com.bkav.isoonline.models.UserModel;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.SQLException;
import java.text.ParseException;
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
        try {
            mTroubleAdapter = new TroubleAdapter(getListTrouble(), this);
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewTrouble.setLayoutManager(linearLayoutManager);
        try {
            setAnimation(R.anim.left_to_right);
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        Log.i("HaiKH", "onCreateView: 1");
        return view;
    }
    
    private List<Trouble> getListTrouble() throws SQLException, ParseException {
        String query = "select DISTINCT  p.ID\n" +
                "      ,p.Code\n" +
                "      ,p.Name\n" +
                "      ,p.EmergencyTypeID\n" +
                "\t  ,e.ProblemEmergencyName\n" +
                "      ,p.ProblemTypeID\n" +
                "\t  ,t.ProblemTypeName\n" +
                "      ,p.CriticalLevelID\n" +
                "\t  ,p.Name as CriticalLevelName\n" +
                "      ,p.ProblemGroupID\n" +
                "\t  ,g.ProblemGroupName\n" +
                "      ,OccuredDate\n" +
                "      ,ResolvedDate\n" +
                "      ,p.Description\n" +
                "      ,[Reason]\n" +
                "      ,[Propose]\n" +
                "      ,[Solution]\n" +
                "      ,[Result]\n" +
                "      ,[StatusID]\n" +
                "\t  ,s.ProblemStatusName\n" +
                "      ,p.CreatedAt\n" +
                "      ,p.CreatedBy\n" +
                "      ,p.UpdatedAt\n" +
                "      ,p.UpdatedBy\n" +
                "      ,p.IsProblemOrEvent\n" +
                "      ,p.IsDelete\n" +
                "      ,[Reporter]\n" +
                "      ,p.ContactNumber\n" +
                "      ,p.ReporterEmail\n" +
                "      ,p.ReporterDepartment\n" +
                "      ,p.Receiver\n" +
                "      ,p.IsTemplate\n" +
                "      ,p.RequestDepID\n" +
                "\t  ,rd.Name as RequestDepName\n" +
                "      ,p.ResidentAgencyID\n" +
                "\t  ,r.Name as ResidentAgencyName\n" +
                "      ,p.ResidentAgencyGroupID\n" +
                "\t  ,rp.Name as ResidentAgencyGroupName\n" +
                "      ,[YourselfFix]\n" +
                "      ,[OnDuty]\n" +
                "      ,[ReceiverDepID]\n" +
                "      ,[lng]\n" +
                "      ,[lat] \n" +
                "from V3ProblemEvent as p\n" +
                "left join V3ProblemEventUser as u on  u.ProblemEventID = p.ID\n" +
                "left join V3ProblemType as t on p.ProblemTypeID = t.ID\n" +
                "left join V3ProblemStatus as s on p.StatusID = s.ID\n" +
                "left join V3ProblemEmergency as e on p.EmergencyTypeID = e.ID\n" +
                "left join V3ProblemCriticalLevel as c on p.CriticalLevelID = c.ID\n" +
                "left join V3ProblemGroup as g on p.ProblemGroupID = g.ID\n" +
                "left join V3ProblemResidentAgency as r on p.ResidentAgencyID = r.ID\n" +
                "left join V3ProblemResidentAgencyGroup as rp on p.ResidentAgencyGroupID = rp.ID\n" +
                "left join V3ProblemEventRequestDep as rd on p.RequestDepID = rd.ID\n" +
                "where \n" +
                "(u.HumanEmployeeID = " + Golobal.getIdUser() +" or p.Receiver = " + Golobal.getIdUser() +")\n" +
                "and (p.IsDelete = 0 or p.IsDelete is null)";

        TroubleModel model = new TroubleModel();
        List<Trouble> lst = new ArrayList<>();
                lst = model.getTroublelist(query);
        return lst;
    }
    private void setAnimation(int animResource) throws SQLException, ParseException {
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
