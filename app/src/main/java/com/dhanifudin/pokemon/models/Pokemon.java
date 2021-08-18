package com.dhanifudin.pokemon.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon implements Parcelable {

	@PrimaryKey(autoGenerate = true)
	@NonNull
	private int id;
	private String name;
	private String type;
	private int level;

	@Ignore
	public Pokemon(String name, String type, int level) {
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public Pokemon(int id, String name, String type, int level) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.name);
		dest.writeString(this.type);
		dest.writeInt(this.level);
	}

	public void readFromParcel(Parcel source) {
		this.id = source.readInt();
		this.name = source.readString();
		this.type = source.readString();
		this.level = source.readInt();
	}

	protected Pokemon(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.type = in.readString();
		this.level = in.readInt();
	}

	public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
		@Override
		public Pokemon createFromParcel(Parcel source) {
			return new Pokemon(source);
		}

		@Override
		public Pokemon[] newArray(int size) {
			return new Pokemon[size];
		}
	};
}
