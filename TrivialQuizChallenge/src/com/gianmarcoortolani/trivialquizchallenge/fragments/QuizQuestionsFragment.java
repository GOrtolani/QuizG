package com.gianmarcoortolani.trivialquizchallenge.fragments;


import java.util.List;

import com.gianmarcoortolani.trivialquizchallenge.R;
import com.gianmarcoortolani.trivialquizchallenge.activities.QuizGameoverActivity;
import com.gianmarcoortolani.trivialquizchallenge.data.QuizQuestions;
import com.gianmarcoortolani.trivialquizchallenge.db.QuizSQliteDB;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuizQuestionsFragment extends Fragment {

	List<QuizQuestions> quesList;
	
	public static int score = 0;
	
	int qid = 0;
	
	QuizQuestions currentQ;
	
	TextView txtQuestion;
	
	RadioButton mAnswer1, mAnswer2, mAnswer3;
	
	RadioGroup grp;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
    	   	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// Inflate the layout for this fragment
		final View v = inflater.inflate(R.layout.fragment_quiz_questions, container, false);
        
		QuizSQliteDB db = new QuizSQliteDB(getActivity());
		
		quesList = db.getAllQuestions();
		
		currentQ = quesList.get(qid);
		
		txtQuestion = (TextView)v.findViewById(R.id.questions_text);
		
		mAnswer1 = (RadioButton)v.findViewById(R.id.answer1);
		mAnswer2 = (RadioButton)v.findViewById(R.id.answer2);
		mAnswer3 = (RadioButton)v.findViewById(R.id.answer3);
		
		setQuestionView();
		
		grp = (RadioGroup)v.findViewById(R.id.radioGroup1);
		grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	        @Override
	        public void onCheckedChanged(RadioGroup arg0, int arg1) {
	            // TODO Auto-generated method stub
	        	
	        	RadioButton answer=(RadioButton)v.findViewById(grp.getCheckedRadioButtonId());
	            
	            	if(currentQ.getRightAnswer().equals(answer.getText())) {
	            		//add score
						score++;
						
						// uncheck radial button 
						mAnswer1.setChecked(false);
						mAnswer2.setChecked(false);
						mAnswer3.setChecked(false);
					}
	            	// check if the number of question is lower then 5
					if(qid<5){					
						currentQ=quesList.get(qid);
						// set question 
						setQuestionView();
						
						mAnswer1.setChecked(false);
						mAnswer2.setChecked(false);
						mAnswer3.setChecked(false);
						
					}else{
						
						// sent intent to QuizGameoverActivity for the score
						Intent intent = new Intent();
						intent.setClass(getActivity(), QuizGameoverActivity.class);
						Bundle b = new Bundle();
						
						//Your score
						b.putInt("score", score); 
						
						//Put your score to your next Intent
						intent.putExtras(b); 
						startActivity(intent);											
					}
	            }
	           
	    });
		
        return v;		
	}
	
	private void setQuestionView() {
		
		// set the answers on the view
		txtQuestion.setText(currentQ.getQuestion());
		mAnswer1.setText(currentQ.getAnswer1());
		mAnswer2.setText(currentQ.getAnswer2());
		mAnswer3.setText(currentQ.getAnswer3());
		qid++;
	}		
}