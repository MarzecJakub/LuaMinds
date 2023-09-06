package com.example.licencjat;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Achievements#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Achievements extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Achievements() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Achievements.
     */
    // TODO: Rename and change types and number of parameters
    public static Achievements newInstance(String param1, String param2) {
        Achievements fragment = new Achievements();
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
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences prefs = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        int completedQuizzes = prefs.getInt("completed_quizzes", 0);
        int totalPoints = prefs.getInt("total_points", 0);
        int quizRes5 = prefs.getInt("quizRes5", 0);

        Log.d("completedQuizzes", "completedQuizzes: " + completedQuizzes);
        Log.d("totalPoints", "totalPoints: " + totalPoints);
        Log.d("quizRes5", "quizRes5: " + quizRes5);


        TextView txtCompletedQuizzes = view.findViewById(R.id.numberQuiz);
        TextView txtPointsQuiz = view.findViewById(R.id.pointsQuiz);
        TextView txtMaxQuiz = view.findViewById(R.id.maxQuiz);

        txtCompletedQuizzes.setText("Ilość quizów: "+completedQuizzes);
        txtPointsQuiz.setText("Zdobyte punkty: "+totalPoints);
        txtMaxQuiz.setText("Maksymalny wynik: "+quizRes5);

        ImageView imgCompletedQuizzes = view.findViewById(R.id.numberQuizImg);
        ImageView imgPointsQuiz = view.findViewById(R.id.pointsQuizImg);
        ImageView imgMaxQuiz = view.findViewById(R.id.maxQuizImg);


        if (completedQuizzes >= 0 && completedQuizzes < 5) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron0);
        } else if (completedQuizzes >= 5 && completedQuizzes < 10) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron1);
        } else if (completedQuizzes >= 10 && completedQuizzes < 15) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron2);
        } else if (completedQuizzes >= 15 && completedQuizzes < 25) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron3);
        } else if (completedQuizzes >= 25 && completedQuizzes < 50) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron4);
        } else if (completedQuizzes >= 50 && completedQuizzes < 100) {
            imgCompletedQuizzes.setImageResource(R.drawable.iron5);
        } else {
            imgCompletedQuizzes.setImageResource(R.drawable.iron6);
        }


        if (totalPoints >= 0 && totalPoints < 15) {
            imgPointsQuiz.setImageResource(R.drawable.diamond0);
        } else if (totalPoints >= 15 && totalPoints < 30) {
            imgPointsQuiz.setImageResource(R.drawable.diamond1);
        } else if (totalPoints >= 30 && totalPoints < 45) {
            imgPointsQuiz.setImageResource(R.drawable.diamond2);
        } else if (totalPoints >= 45 && totalPoints < 75) {
            imgPointsQuiz.setImageResource(R.drawable.diamond3);
        } else if (totalPoints >= 75 && totalPoints < 150) {
            imgPointsQuiz.setImageResource(R.drawable.diamond4);
        } else if (totalPoints >= 150 && totalPoints < 300) {
            imgPointsQuiz.setImageResource(R.drawable.diamond5);
        } else {
            imgPointsQuiz.setImageResource(R.drawable.diamond6);
        }

        if (quizRes5 >= 0 && quizRes5 < 5) {
            imgMaxQuiz.setImageResource(R.drawable.ruby0);
        } else if (quizRes5 >= 5 && quizRes5 < 10) {
            imgMaxQuiz.setImageResource(R.drawable.ruby1);
        } else if (quizRes5 >= 10 && quizRes5 < 15) {
            imgMaxQuiz.setImageResource(R.drawable.ruby2);
        } else if (quizRes5 >= 15 && quizRes5 < 25) {
            imgMaxQuiz.setImageResource(R.drawable.ruby3);
        } else if (quizRes5 >= 25 && quizRes5 < 50) {
            imgMaxQuiz.setImageResource(R.drawable.ruby4);
        } else if (quizRes5 >= 50 && quizRes5 < 100) {
            imgMaxQuiz.setImageResource(R.drawable.ruby5);
        } else {
            imgMaxQuiz.setImageResource(R.drawable.ruby6);
        }





    }
}