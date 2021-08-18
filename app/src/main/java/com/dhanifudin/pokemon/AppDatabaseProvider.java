package com.dhanifudin.pokemon;

import android.content.Context;

import androidx.room.Room;

import com.dhanifudin.pokemon.db.AppDatabase;

public class AppDatabaseProvider {

	private static AppDatabase instance = null;

	public static AppDatabase getInstance(Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(context, AppDatabase.class, "pokemon.db")
				.allowMainThreadQueries()
				.build();
		}
		return instance;
	}
}
