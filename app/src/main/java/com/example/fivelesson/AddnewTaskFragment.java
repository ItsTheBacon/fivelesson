package com.example.fivelesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddnewTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddnewTaskFragment extends Fragment {
    EditText etSend;
    Button btnSend;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddnewTaskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddnewTaskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddnewTaskFragment newInstance(String param1, String param2) {
        AddnewTaskFragment fragment = new AddnewTaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addnew_task, container, false);
        etSend = view.findViewById(R.id.et_send_taskFragment);
        btnSend = view.findViewById(R.id.btn_add_taskFragment);
        btnSend.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", etSend.getText().toString());
         getActivity().getSupportFragmentManager().setFragmentResult("title",bundle);
         getActivity().getSupportFragmentManager().popBackStack();

        });
        // Inflate the layout for this fragment
        return view;
    }
}