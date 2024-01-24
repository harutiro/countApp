package net.harutiro.countapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountType(
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
    val type: Int,
    val dateList: MutableList<String>,
    val count: Int
)