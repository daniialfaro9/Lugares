package com.example.lugares.data

import androidx.room.Dao
import androidx.room.

@Dao
interface LugarDao {
    @Query ("SELECT * FROM lUGAR ")
}

