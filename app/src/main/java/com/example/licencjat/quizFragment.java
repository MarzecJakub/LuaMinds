package com.example.licencjat;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link quizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quizFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public quizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment quizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static quizFragment newInstance(String param1, String param2) {
        quizFragment fragment = new quizFragment();
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
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    List<Questions> quesList;
    int score=0;
    int qid=0;
    Questions currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    ImageView imgQuizz;

    TextView idQuestion;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DbHelperQuiz db= new DbHelperQuiz(getActivity());
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=view.findViewById(R.id.textView1);
        rda=view.findViewById(R.id.radio0);
        rdb=view.findViewById(R.id.radio1);
        rdc=view.findViewById(R.id.radio2);
        butNext=view.findViewById(R.id.button1);
        imgQuizz=view.findViewById(R.id.imgQuiz);
        idQuestion=view.findViewById(R.id.idQuestion);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("qid", String.valueOf(qid));
                RadioGroup grp=view.findViewById(R.id.radioGroup1);
                RadioButton answer=view.findViewById(grp.getCheckedRadioButtonId());
                int selectedId = grp.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(getContext(), "Wybierz odpowiedź", Toast.LENGTH_SHORT).show();
                    return;
                }
                grp.clearCheck();
                Log.d("twojaodp", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Twój wynik:"+score);
                }
                if(qid == 4){
                    butNext.setText("Zakończ");
                }
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                } else{
                    NavController navController = Navigation.findNavController(view);
                    NavDirections action = quizFragmentDirections.actionQuizFragmentToQuizResult(String.valueOf(score));
                    navController.navigate(action);

                }
            }
        });


    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTIONS());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        imgQuizz.setImageResource(currentQ.getIMAGE());
        qid++;
        idQuestion.setText(qid+"/5");
    }

}