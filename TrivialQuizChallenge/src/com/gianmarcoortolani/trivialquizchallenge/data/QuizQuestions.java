package com.gianmarcoortolani.trivialquizchallenge.data;

public class QuizQuestions {
	
	private int mId;
	
	private String mQuestion;
	
	private String mAnswer1;
	
	private String mAnswer2;
	
	private String mAnswer3;
	
	private String mRightAnswer;
	
	public QuizQuestions(String question, String answer1, String answer2, String answer3,
			String rightAnswer) {
		
		mQuestion = question;
		
		mAnswer1 = answer1;
		
		mAnswer2 = answer2;
		
		mAnswer3 = answer3;
		
		mRightAnswer = rightAnswer;
	}
	
	public QuizQuestions() {
		
		mId=0;
		
		mQuestion = "";
		
		mAnswer1 = "";
		
		mAnswer2 = "";
		
		mAnswer3 = "";
		
		mRightAnswer = "";
	}
	
	public int getID() {
		
		return mId;
	}
	
	public void setID(int id) {
		mId = id;
	}
	
	public String getQuestion() {
		
		return mQuestion;
	}
	
	public void setQuestion(String question) {
		
		mQuestion = question;
	}
	
	public String getAnswer1() {
		
		return mAnswer1;
	}
	
	public void setAnswer1(String answer1) {
		
		mAnswer1 = answer1;
	}
	
	public String getAnswer2() {
		
		return mAnswer2;
	}
	
	public void setAnswer2(String answer2) {
		
		mAnswer2 = answer2;
	}
	
	public String getAnswer3() {
		
		return mAnswer3;
	}
	
	public void setAnswer3(String answer3) {
		
		mAnswer3 = answer3;
	}
	
	public String getRightAnswer() 
	{
		return mRightAnswer;
	}
	
	public void setRightAnswer(String rightAnswer) {
		mRightAnswer = rightAnswer;
	}	
}