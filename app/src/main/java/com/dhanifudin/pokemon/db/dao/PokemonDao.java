package com.dhanifudin.pokemon.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dhanifudin.pokemon.models.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

	@Query("select * from pokemon")
	List<Pokemon> getAll();

	@Insert
	void insert(Pokemon... pokemons);

	@Update
	void update(Pokemon pokemon);

	@Delete
	void delete(Pokemon pokemon);
}
