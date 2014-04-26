package com.gianmarcoortolani.trivialquizchallenge.fragments;

import com.gianmarcoortolani.trivialquizchallenge.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class QuizGameoverFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
		
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_quiz_gameover, container, false);
		
		RatingBar bar=(RatingBar)v.findViewById(R.id.ratingBar1); 
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		
		//get text view
		TextView t = (TextView)v.findViewById(R.id.textResult);
		
		//get score		
		Bundle b = getActivity().getIntent().getExtras();
		int score= b.getInt("score");
		
		//display score
		bar.setRating(score);
		
		switch (score) {
			case 1:
			case 2: t.setText("try again...");
			break;
			
			case 3:
			case 4:t.setText("come on, you can do it");
			break;
			
			case 5:t.setText("Wow you are a genius!");
			break;
			
		}
		return v;
	}	
}
