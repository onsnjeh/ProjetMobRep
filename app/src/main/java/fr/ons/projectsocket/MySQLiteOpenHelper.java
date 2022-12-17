package fr.ons.projectsocket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private String creation="create Table Formulaire(id TEXT primary key, Q1 TEXT,Q2 TEXT, Q3 TEXT ,Q4 TEXT ,Q5 TEXT,Q6 TEXT,Q7 TEXT)";

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//SQLiteDatabase db : executer la requet
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creation);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
