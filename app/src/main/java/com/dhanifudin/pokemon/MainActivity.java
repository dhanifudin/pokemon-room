package com.dhanifudin.pokemon;

import android.content.Intent;
import android.os.Bundle;

import com.dhanifudin.pokemon.adapters.PokemonAdapter;
import com.dhanifudin.pokemon.db.dao.PokemonDao;
import com.dhanifudin.pokemon.models.Pokemon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final int INSERT_REQUEST_CODE = 100;

	private RecyclerView pokemonView;
	private PokemonAdapter adapter;
	private PokemonDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonView = findViewById(R.id.rv_pokemons);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = AppDatabaseProvider.getInstance(this).pokemonDao();
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		adapter = new PokemonAdapter();
		pokemonView.setLayoutManager(layoutManager);
		pokemonView.setAdapter(adapter);

		List<Pokemon> items = dao.getAll();
		adapter.setItems(items);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            	Pokemon pokemon1 = new Pokemon("Pikachu", "Listrik", 10);
//				Pokemon pokemon2 = new Pokemon("Bulbasour", "Rumput", 10);
//				dao.insert(pokemon1, pokemon2);
//				List<Pokemon> items = dao.getAll();
//				adapter.setItems(items);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
				Intent intent = new Intent(MainActivity.this, SaveActivity.class);
           		startActivityForResult(intent, INSERT_REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == INSERT_REQUEST_CODE && resultCode == RESULT_OK) {
			Pokemon pokemon = data.getParcelableExtra("NEW_ITEM");
			dao.insert(pokemon);
		}
		List<Pokemon> items = dao.getAll();
		adapter.setItems(items);
	}
}