package com.gianmarcoortolani.trivialquizchallenge.activities;


import com.gianmarcoortolani.trivialquizchallenge.fragments.QuizGameoverFragment;
import com.gianmarcoortolani.trivialquizchallenge.fragments.QuizQuestionsFragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class QuizGameoverActivity extends SingleFragmentActivity {
	
	@Override
    protected Fragment createFragment() {
        return new QuizGameoverFragment();
	}

    @Override
    public void onCreate( Bundle savedInstanceState ) {
	
    	super.onCreate(savedInstanceState);
	
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  	
    }
    
    public void returnMenu (View view) {
		
    	QuizQuestionsFragment.score = 0; 
    	Intent intent = new Intent (view.getContext(), QuizMenuActivity.class);
    	startActivity(intent); 
    	
	}
}
