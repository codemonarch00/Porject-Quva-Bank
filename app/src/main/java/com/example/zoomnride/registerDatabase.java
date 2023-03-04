package com.example.zoomnride;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Register.class}, version = 1)
public  abstract class registerDatabase extends RoomDatabase
{
    private static registerDatabase instance;

    public abstract RegisterAccess registerAccess();

    public static synchronized registerDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),registerDatabase.class,
                    "register_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
