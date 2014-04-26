package com.gianmarcoortolani.trivialquizchallenge.fragments;

import com.gianmarcoortolani.trivialquizchallenge.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuizRulesFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_quiz_rules, container, false);
	}

}
