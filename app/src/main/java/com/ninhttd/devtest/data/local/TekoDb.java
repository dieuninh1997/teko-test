package com.ninhttd.devtest.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ninhttd.devtest.BuildConfig;
import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.local.dao.ProductDao;


@Database(entities = {Product.class}, version = BuildConfig.VERSION_CODE, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class TekoDb extends RoomDatabase {
    public static String DATABASE_NAME = "teko_db";
    private static TekoDb db;

    public static TekoDb getTekoDb() {
        if (db == null) {
            db = Room.databaseBuilder(TekoApplication.getAppContext(), TekoDb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .setJournalMode(JournalMode.TRUNCATE)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }

    public static void deleteDb(Context context) {
        context.deleteDatabase(DATABASE_NAME);
        db = null;
    }

    public abstract ProductDao productDao();
}
