package com.ninhttd.devtest.data.local

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.ninhttd.devtest.BuildConfig
import com.ninhttd.devtest.TekoApplication
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.local.dao.ProductDao
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration


@Database(entities = [ProductEntity::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
@TypeConverters(Converter::class)
abstract class TekoDb : RoomDatabase() {

    abstract fun productDao(): ProductDao


    companion object {
        var DATABASE_NAME = "teko_db"
        private var db: TekoDb? = null

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Since we didn't alter the table, there's nothing else to do here.
            }
        }

        val tekoDb: TekoDb
            get() {
                if (db == null) {
                    db = Room.databaseBuilder(TekoApplication.appContext!!, TekoDb::class.java, DATABASE_NAME)
                            .addMigrations(MIGRATION_1_2)
                            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return db as TekoDb
            }

        fun deleteDb(context: Context) {
            context.deleteDatabase(DATABASE_NAME)
            db = null
        }
    }
}
