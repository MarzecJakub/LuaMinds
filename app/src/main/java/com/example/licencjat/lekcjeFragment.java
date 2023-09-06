package com.example.licencjat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link lekcjeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lekcjeFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Lekcje> lekcjeArrayList;

    private String[] tytulLekcji;

    private int[] zdjecieID;

    private View recyclerview;

    public lekcjeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lekcjeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static lekcjeFragment newInstance(String param1, String param2) {
        lekcjeFragment fragment = new lekcjeFragment();
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
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ((MainActivity) requireActivity()).getSupportActionBar().hide();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lekcje, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();

        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(), lekcjeArrayList);

        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


    }

    private void dataInitialize() {
        lekcjeArrayList = new ArrayList<>();

        tytulLekcji = new String[]{
                getString(R.string.l_0),
                getString(R.string.l_1),
                getString(R.string.l_2),
                getString(R.string.l_3),
                getString(R.string.l_4),
                getString(R.string.l_5),
                getString(R.string.l_6),
                getString(R.string.l_7),
                getString(R.string.l_8),
                getString(R.string.l_9),
                getString(R.string.l_10)
        };

        zdjecieID = new int[]{
                R.drawable.l1,
                R.drawable.l1w,
                R.drawable.l2,
                R.drawable.l3w,
                R.drawable.l4w,
                R.drawable.l5,
                R.drawable.l6w,
                R.drawable.l7,
                R.drawable.l8,
                R.drawable.l9w,
                R.drawable.l10
        };

        for (int i = 0; i < tytulLekcji.length; i++){
            Lekcje lekcje = new Lekcje(tytulLekcji[i], zdjecieID[i]);
            lekcjeArrayList.add(lekcje);
        }

    }



}