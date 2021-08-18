package com.dhanifudin.pokemon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanifudin.pokemon.R;
import com.dhanifudin.pokemon.models.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

	private List<Pokemon> items;

	public PokemonAdapter() {
	}

	public void setItems(List<Pokemon> items) {
		this.items = items;
		this.notifyDataSetChanged();
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.item_pokemon, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Pokemon item = items.get(position);
		holder.nameText.setText(item.getName());
		holder.typeText.setText(item.getType());
		holder.levelText.setText(String.valueOf(item.getLevel()));
	}

	@Override
	public int getItemCount() {
		return (items == null) ? 0 : items.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		TextView nameText;
		TextView typeText;
		TextView levelText;
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			nameText = itemView.findViewById(R.id.text_name);
			typeText = itemView.findViewById(R.id.text_type);
			levelText = itemView.findViewById(R.id.text_level);
		}
	}
}
