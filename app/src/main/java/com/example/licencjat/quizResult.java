package com.example.licencjat;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link quizResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quizResult extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextView myTextView;

    public quizResult() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment quizResult.
     */
    // TODO: Rename and change types and number of parameters
    public static quizResult newInstance(String param1, String param2) {
        quizResult fragment = new quizResult();
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
        View view =  inflater.inflate(R.layout.fragment_quiz_result, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = view.findViewById(R.id.backtomenu);
        NavController navController = Navigation.findNavController(view);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_quizResult_to_menuStartu3);
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true ) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(R.id.action_quizResult_to_menuStartu3);
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        String score = quizResultArgs.fromBundle(getArguments()).getResultValue();
        int scoreInt = Integer.parseInt(score);


        TextView result = view.findViewById(R.id.result);

        SharedPreferences prefs = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        ImageView quizIMG = view.findViewById(R.id.quizIMGres);




        if (scoreInt == 5) {
            result.setText("Twój wynik to: 100%");
            quizIMG.setImageResource(R.drawable.quiz_res_5);
            int quizRes5 = prefs.getInt("quizRes5", 0);
            editor.putInt("quizRes5", quizRes5 + 1);
        } else if (scoreInt == 4) {
            result.setText("Twój wynik to: 80%");
            quizIMG.setImageResource(R.drawable.quiz_res_4);
            int quizRes4 = prefs.getInt("quizRes4", 0);
            editor.putInt("quizRes4", quizRes4+ 1);
        } else if (scoreInt == 3) {
            result.setText("Twój wynik to: 60%");
            quizIMG.setImageResource(R.drawable.quiz_res_3);
            int quizRes3 = prefs.getInt("quizRes3", 0);
            editor.putInt("quizRes3", quizRes3 + 1);
        } else if (scoreInt == 2) {
            result.setText("Twój wynik to: 40%");
            quizIMG.setImageResource(R.drawable.quiz_res_2);
            int quizRes2 = prefs.getInt("quizRes2", 0);
            editor.putInt("quizRes2", quizRes2 + 1);
        } else if (scoreInt == 1) {
            result.setText("Twój wynik to: 20%");
            quizIMG.setImageResource(R.drawable.quiz_res_1);
            int quizRes1 = prefs.getInt("quizRes1", 0);
            editor.putInt("quizRes1", quizRes1 + 1);
        } else {
            result.setText("Twój wynik to: 0% :(");
            quizIMG.setImageResource(R.drawable.quiz_res_0);
            int quizRes0 = prefs.getInt("quizRes0", 0);
            editor.putInt("quizRes0", quizRes0 + 1);
        }

        int completedQuizzes = prefs.getInt("completed_quizzes", 0);
        editor.putInt("completed_quizzes", completedQuizzes + 1);

        int totalPoints = prefs.getInt("total_points", 0);
        editor.putInt("total_points", totalPoints + scoreInt);

    //to do zakomentowania do ostatecznej wersji
        editor.putInt("completed_quizzes", 100);
        editor.putInt("total_points", 220);
        editor.putInt("quizRes5",  15);
        editor.putInt("quizRes4",  10);
        editor.putInt("quizRes3",  30);
        editor.putInt("quizRes2",  13);
        editor.putInt("quizRes1",  10);
        editor.putInt("quizRes0",  5);


        editor.apply();



        int quizRes0 = prefs.getInt("quizRes0", 0);
        int quizRes1 = prefs.getInt("quizRes1", 0);
        int quizRes2 = prefs.getInt("quizRes2", 0);
        int quizRes3 = prefs.getInt("quizRes3", 0);
        int quizRes4 = prefs.getInt("quizRes4", 0);
        int quizRes5 = prefs.getInt("quizRes5", 0);

        BarChart chart = view.findViewById(R.id.bar_chart);

// Stwórz listę wyników quizów.
        List<Integer> results = new ArrayList<>();
        results.add(quizRes0);
        results.add(quizRes1);
        results.add(quizRes2);
        results.add(quizRes3);
        results.add(quizRes4);
        results.add(quizRes5);

// Stwórz listę opisów dla każdego wyniku.
        List<String> labels = new ArrayList<>();
        labels.add("0%");
        labels.add("20%");
        labels.add("40%");
        labels.add("60%");
        labels.add("80%");
        labels.add("100%");

// Stwórz listę kolorów dla każdego wyniku.
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#f54643"));
        colors.add(Color.parseColor("#f3a64e"));
        colors.add(Color.parseColor("#fdf795"));
        colors.add(Color.parseColor("#b5f59e"));
        colors.add(Color.parseColor("#9ccef3"));
        colors.add(Color.CYAN);

// Stwórz listę słupków dla danych.
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            entries.add(new BarEntry(i, results.get(i)));
        }

// Stwórz zestaw danych dla wykresu.
        BarDataSet dataSet = new BarDataSet(entries, "Wyniki");
        dataSet.setValueFormatter(new IntegerValueFormatter());
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(14f);
        dataSet.setColors(colors);


// Stwórz obiekt danych dla wykresu.
        BarData barData = new BarData(dataSet);


// Ustaw opisy dla osi X.
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(true);
        xAxis.setTextSize(16f);
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);

        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        YAxis yAxisL = chart.getAxisLeft();
        yAxisL.setDrawLabels(false);
        yAxisL.setDrawAxisLine(false);
        yAxisL.setDrawGridLines(false);
        yAxisL.setAxisMaximum(100f);

        YAxis yAxisR = chart.getAxisRight();
        yAxisR.setDrawLabels(false);
        yAxisR.setDrawAxisLine(false);
        yAxisR.setDrawGridLines(false);

// Konfiguruj wykres.
        chart.setData(barData);
        chart.setDescription(null);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setHighlightPerTapEnabled(false);
        chart.setTouchEnabled(false);
        chart.invalidate();



//        chart.getDescription().setEnabled(false);
//        chart.setDrawValueAboveBar(true);
//        chart.animateY(1000);




    }



}