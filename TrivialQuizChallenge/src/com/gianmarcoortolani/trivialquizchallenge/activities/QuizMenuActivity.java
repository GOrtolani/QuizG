package com.gianmarcoortolani.trivialquizchallenge.activities;

import com.gianmarcoortolani.trivialquizchallenge.fragments.QuizMenuFragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class QuizMenuActivity extends SingleFragmentActivity {
	
	@Override
    protected Fragment createFragment() {
        return new QuizMenuFragment();
	}   
	
	
	@Override
    public void onCreate( Bundle savedInstanceState ) {
	
		super.onCreate(savedInstanceState);
	
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	
    }
	
	public void startGame (View view) {
		
    	Intent intent = new Intent (view.getContext(), QuizQuestionsActivity.class);
    	startActivity(intent);       
	}

	public void rulesMenu (View view) {
	
		Intent intent = new Intent (view.getContext(), QuizRulesActivity.class);
		startActivity(intent);       
	}
}
