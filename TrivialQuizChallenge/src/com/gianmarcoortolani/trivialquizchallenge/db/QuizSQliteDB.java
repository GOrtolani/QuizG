package com.gianmarcoortolani.trivialquizchallenge.db;

import java.util.ArrayList;
import java.util.List;

import com.gianmarcoortolani.trivialquizchallenge.data.QuizQuestions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizSQliteDB extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 2;
	
	// Database Name
	private static final String DATABASE_NAME = "mTriviaQuiz";
	
	// tasks table name
	private static final String TABLE_QUEST = "mQuest";
	
	// tasks Table Columns names
	private static final String KEY_ID = "mId";
	
	private static final String KEY_QUES = "mQuestion";
	
	//correct option
	private static final String KEY_RIGHT_ANSWER = "mRightAnswer"; 
	
	//option a
	private static final String KEY_ANSWER1= "mAswer1"; 
	
	//option b
	private static final String KEY_ANSWER2= "mAswer2"; 
	
	//option c
	private static final String KEY_ANSWER3= "mAswer3"; 
	
	private SQLiteDatabase dbase;
	
	public QuizSQliteDB(Context context) {
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		dbase=db;
		
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_RIGHT_ANSWER+ " TEXT, "+ KEY_ANSWER1 +" TEXT, "
				+ KEY_ANSWER2 +" TEXT, "+ KEY_ANSWER3 +" TEXT)";
		
		db.execSQL(sql);		
		
		addQuestions();
	}
	
	private void addQuestions() {
		
		QuizQuestions question1 = new QuizQuestions("What type of creature" + 
		" is a flickertail ?", "Dragonfly", "Monkey", "Squirrel", "Squirrel");
		addQuestion(question1);
		
		QuizQuestions question2 = new QuizQuestions("Who was south Africa's" + 
		" first black president ?", "Nelson Mandela", "Jhon Gary", "Wiliam Burton", "Nelson Mandela");
		addQuestion(question2);
		
		QuizQuestions question3 = new QuizQuestions("Which colours" + 
		" make purple ?","Red and Green", "Green and Orange", "Red and Blue", "Red and Blue");
		addQuestion(question3);
		
		QuizQuestions question4 = new QuizQuestions("What name is given to the Buddhist practice" + 
		" of mental concentration?", "Moderation", "Modification", "Meditation", "Meditation");
		addQuestion(question4);
		
		QuizQuestions question5 = new QuizQuestions("What score must a Ten-Pin bowler make" +
		" to achieve a perfect game?", "200", "300", "150", "300");
		addQuestion(question5);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		
		// Create tables again
		onCreate(db);
	}
	
	// Adding new question
	public void addQuestion(QuizQuestions quest) {
		
		ContentValues values = new ContentValues();
		
		values.put(KEY_QUES, quest.getQuestion()); 
		
		values.put(KEY_RIGHT_ANSWER, quest.getRightAnswer());
		
		values.put(KEY_ANSWER1, quest.getAnswer1());
		
		values.put(KEY_ANSWER2, quest.getAnswer2());
		
		values.put(KEY_ANSWER3, quest.getAnswer3());
		
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	
	public List<QuizQuestions> getAllQuestions() {
		
		List<QuizQuestions> quesList = new ArrayList<QuizQuestions>();
		
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				QuizQuestions quest = new QuizQuestions();
				
				quest.setID(cursor.getInt(0));
				
				quest.setQuestion(cursor.getString(1));
				
				quest.setRightAnswer(cursor.getString(2));
				
				quest.setAnswer1(cursor.getString(3));
				
				quest.setAnswer2(cursor.getString(4));
				
				quest.setAnswer3(cursor.getString(5));
				
				quesList.add(quest);
				
			} while (cursor.moveToNext());
		}
		
		// return quest list
		return quesList;
	}
	
	public int rowcount() {
		
		int row = 0;		
		
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row = cursor.getCount();
		
		return row;
	}
}