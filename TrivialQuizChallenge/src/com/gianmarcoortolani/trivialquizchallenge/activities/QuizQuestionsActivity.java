package com.gianmarcoortolani.trivialquizchallenge.activities;

import com.gianmarcoortolani.trivialquizchallenge.fragments.QuizQuestionsFragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class QuizQuestionsActivity extends SingleFragmentActivity {
	
	protected Fragment createFragment() {
        return new QuizQuestionsFragment();
	}
	
	@Override
    public void onCreate( Bundle savedInstanceState ) {
	
		super.onCreate(savedInstanceState);
	
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }	
}
