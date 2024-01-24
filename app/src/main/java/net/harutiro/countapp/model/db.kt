package net.harutiro.countapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CountType::class], version = 1)
@TypeConverters(ContentTextTypeConverter::class)
abstract class Db: RoomDatabase() {
    abstract fun dao(): dao
}