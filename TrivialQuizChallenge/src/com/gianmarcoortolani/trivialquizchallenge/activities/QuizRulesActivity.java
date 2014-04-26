package com.gianmarcoortolani.trivialquizchallenge.activities;

import com.gianmarcoortolani.trivialquizchallenge.fragments.QuizRulesFragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class QuizRulesActivity extends SingleFragmentActivity {
	
	@Override
    protected Fragment createFragment() {
        return new QuizRulesFragment();
	}
	
	@Override
    public void onCreate( Bundle savedInstanceState ) {
	
		super.onCreate(savedInstanceState);
	
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	
    }

}
