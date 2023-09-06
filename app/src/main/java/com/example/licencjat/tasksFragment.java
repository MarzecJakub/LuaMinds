package com.example.licencjat;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tasksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Tasks> tasksArrayList;

    private String[] titleTask;
    private int[] picTask;
    private String[] taskText;
    private int[] taskPic;
    private int[] taskSol;


    private View recyclerview2;

    public tasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tasksFragment newInstance(String param1, String param2) {
        tasksFragment fragment = new tasksFragment();
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
        return inflater.inflate(R.layout.fragment_tasks, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        RecyclerView recyclerview2 = view.findViewById(R.id.recyclerview2);
        recyclerview2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview2.setHasFixedSize(true);
        MyAdapter2 myAdapter2 = new MyAdapter2(getContext(), tasksArrayList);
        recyclerview2.setAdapter(myAdapter2);
        myAdapter2.notifyDataSetChanged();


        //menu bar change
        view.setFitsSystemWindows(true);
        Window window = getActivity().getWindow();
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.blue_tasks));

    }


    private void dataInitialize() {
        tasksArrayList = new ArrayList<>();

        titleTask = new String[]{
                getString(R.string.t_5_1),
                getString(R.string.t_5_2),
                getString(R.string.t_5_3),
                getString(R.string.t_6_1),
                getString(R.string.t_6_2),
                getString(R.string.t_6_3),
                getString(R.string.t_7_1),
                getString(R.string.t_7_2),
                getString(R.string.t_7_3),
                getString(R.string.t_8_1),
                getString(R.string.t_8_2),
                getString(R.string.t_8_3),

        };

        picTask = new int[]{
                R.drawable.l5,
                R.drawable.l5,
                R.drawable.l5,
                R.drawable.l6w,
                R.drawable.l6w,
                R.drawable.l6w,
                R.drawable.l7,
                R.drawable.l7,
                R.drawable.l7,
                R.drawable.l8,
                R.drawable.l8,
                R.drawable.l8,

        };

        taskText = new String[]{
                getString(R.string.t_5_1_t),
                getString(R.string.t_5_2_t),
                getString(R.string.t_5_3_t),
                getString(R.string.t_6_1_t),
                getString(R.string.t_6_2_t),
                getString(R.string.t_6_3_t),
                getString(R.string.t_7_1_t),
                getString(R.string.t_7_2_t),
                getString(R.string.t_7_5_t),
                getString(R.string.t_8_1_t),
                getString(R.string.t_8_2_t),
                getString(R.string.t_8_3_t),

        };

        taskPic = new int[]{
                R.drawable.tasks_def,
                R.drawable.tasks_def,
                R.drawable.tasks_def,
                R.drawable.t_6_1_p,
                R.drawable.t_6_2_p,
                R.drawable.t_6_3_p,
                R.drawable.tasks_def,
                R.drawable.tasks_def,
                R.drawable.t_7_5_p,
                R.drawable.task2,
                R.drawable.tasks_def,
                R.drawable.tasks_def,

        };

        taskSol = new int[]{
                R.drawable.t_5_1_s,
                R.drawable.tasks_def,
                R.drawable.tasks_def,
                R.drawable.t_6_1_s,
                R.drawable.t_6_2_s,
                R.drawable.t_6_3_s,
                R.drawable.tasks_def,
                R.drawable.tasks_def,
                R.drawable.t_7_5_s,
                R.drawable.t_8_1_s,
                R.drawable.tasks_def,
                R.drawable.tasks_def,

        };

        for (int i = 0; i < titleTask.length; i++){
            Tasks tasks = new Tasks(titleTask[i], picTask[i], taskText[i], taskPic[i], taskSol[i]);
            tasksArrayList.add(tasks);
        }

    }











}