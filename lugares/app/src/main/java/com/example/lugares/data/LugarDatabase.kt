package com.example.lugares.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lugares.model.Lugar

@Database(entities=[Lugar::class],version=1, exportSchema = false)
abstract class LugarDatabase: RoomDatabase() {
    abstract fun lugarDao() : LuagrDao

    companion object {
        @Volatile
        private var INSTANCE: LugarDatabase? =null

        fun getDatabase(context: android.content.Context): LugarDatabase {
            val tempInstance= INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this)
                val intance= Room.databaseBuilder(
                    context.applicationContext,
                    LugarDatabase::class.java,
                    "lugar_database"
                ) .build()
                INSTANCE = intance
                return intance
        }

    }
}