package com.dhanifudin.pokemon.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dhanifudin.pokemon.db.dao.PokemonDao;
import com.dhanifudin.pokemon.models.Pokemon;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

	public abstract PokemonDao pokemonDao();
}
