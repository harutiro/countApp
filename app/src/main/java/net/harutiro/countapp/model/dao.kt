package net.harutiro.countapp.model

import androidx.room.*

@Dao
interface dao {

    @Delete
    fun delete(countType: CountType)

    @Insert
    fun create(countType: CountType)

    @Update
    fun update(countType: CountType)

    //クエリの中身
    @Query("select * from counttype")
    fun getAll(): List<CountType>
}