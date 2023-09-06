package com.example.licencjat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tasksShow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tasksShow extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tasksShow() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tasksShow.
     */
    // TODO: Rename and change types and number of parameters
    public static tasksShow newInstance(String param1, String param2) {
        tasksShow fragment = new tasksShow();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tasks_show, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int taskID = tasksShowArgs.fromBundle(getArguments()).getTaskID();
        String taskTitle = tasksShowArgs.fromBundle(getArguments()).getTaskTitle();
        String taskText = tasksShowArgs.fromBundle(getArguments()).getTaskText();
        int taskPic = tasksShowArgs.fromBundle(getArguments()).getTaskPic();
        int taskSol = tasksShowArgs.fromBundle(getArguments()).getTaskSol();


        TextView title = view.findViewById(R.id.taskTitle);
        TextView text = view.findViewById(R.id.taskText);
        ImageView img = view.findViewById(R.id.taskImg);
        Button solution = view.findViewById(R.id.taskSolution);
        ImageView solutionImg = view.findViewById(R.id.taskImgSolution);


        title.setText(taskTitle);
        text.setText(HtmlCompat.fromHtml(taskText, HtmlCompat.FROM_HTML_MODE_COMPACT));


        img.setImageResource(taskPic);
        solutionImg.setImageResource(taskSol);

        solutionImg.setVisibility(View.GONE);
        solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solutionImg.getVisibility() == View.GONE) {
                    solutionImg.setVisibility(View.VISIBLE);
                } else {
                    solutionImg.setVisibility(View.GONE);
                }
            }
        });
//
//        Log.d("numer zadania", String.valueOf(taskID+1));
//        Log.d(" title", String.valueOf(taskTitle));
//        Log.d("text ", String.valueOf(taskText));
//        Log.d("pic ", String.valueOf(taskPic));

    }
}