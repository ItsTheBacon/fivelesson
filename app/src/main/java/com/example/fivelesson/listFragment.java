package com.example.fivelesson;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listFragment extends Fragment {

    FloatingActionButton fab;
    RecyclerView rvtask;
    TaskFragmentAdapter Adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public listFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @return A new instance of fragment listFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static listFragment newInstance(String title) {
        listFragment fragment = new listFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Adapter = new TaskFragmentAdapter(requireContext());

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
        Adapter.setItemClickList(new ItemClickList() {
            @Override
            public void CLickItem(int position) {
             Bundle bundle = new Bundle();



            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // Inflate the layout for this fragment
        rvtask = view.findViewById(R.id.rv_task);
        fab = view.findViewById(R.id.fab_add_btn);
        rvtask.setAdapter(Adapter);
        rvtask.setLayoutManager(new LinearLayoutManager(requireContext()));
        getActivity().getSupportFragmentManager().setFragmentResultListener("title", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(String requestKey, Bundle result) {
                Adapter.addData(result.getString("title"), result.getString("description"));
                Toast.makeText(requireContext(), result.getString("title"), Toast.LENGTH_SHORT).show();
            }
        });




//        getActivity().getSupportFragmentManager().setFragmentResultListener("title", this, (requestKey, result) -> {
////            Adapter.addData(result.getParcelable("title"));
//
//
//
//        });
//        String title = getArguments().getString("title");
//        Adapter.addData(title);


        onClickFab();

        return view;
    }

    private void onClickFab() {
        fab.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("AddnewTaskFragment").replace(R.id.fragment_container, new AddnewTaskFragment(), "AddnewTaskFragment").commit();

        });
    }

}