package com.oldspace.starcraftnet.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oldspace.starcraftnet.R;
import com.oldspace.starcraftnet.adapter.CitizenAdapter;
import com.oldspace.starcraftnet.adapter.IncidentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        CitizenAdapter citizenAdapter = new CitizenAdapter(container.getContext());
        citizenAdapter.getDetailCitizen(view);
        return view;
    }

}
