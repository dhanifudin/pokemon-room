package com.dhanifudin.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dhanifudin.pokemon.models.Pokemon;

public class SaveActivity extends AppCompatActivity {

	private EditText nameText;
	private EditText typeText;
	private EditText levelText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        nameText = findViewById(R.id.input_name);
		typeText = findViewById(R.id.input_type);
		levelText = findViewById(R.id.input_level);
    }


	public void handleSave(View view) {
		String name = nameText.getText().toString();
		String type = typeText.getText().toString();
		int level = Integer.parseInt(levelText.getText().toString());
		Intent intent = new Intent();
		intent.putExtra("NEW_ITEM", new Pokemon(name, type, level));
		setResult(RESULT_OK, intent);
		finish();
	}
}