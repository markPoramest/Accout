package com.example.accout.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.accout.Model.Expenditure;

@Database(entities = {Expenditure.class}, exportSchema = false, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static final String DB_NAME = "Expenditure.db";
    public abstract ExpenditureDao expenditureDao();
    private static AppDB mInstance;
    public static synchronized AppDB getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDB.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}
