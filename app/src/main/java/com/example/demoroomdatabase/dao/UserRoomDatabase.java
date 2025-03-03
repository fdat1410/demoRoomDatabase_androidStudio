package com.example.demoroomdatabase.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.demoroomdatabase.entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {
    private static UserRoomDatabase instance;
    public abstract UserDAO userDao();
    public static final String DATABASE_NAME = "userRoomDatabaseDemo";
    public static synchronized UserRoomDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
