package net.harutiro.countapp.model

import androidx.room.TypeConverter

class ContentTextTypeConverter {

    @TypeConverter
    fun fromTextItems(value:String?): MutableList<String>?{
        return if(value == null) null else value.split(",").map { it.trim() }.toMutableList()
    }

    @TypeConverter
    fun toTestItems(date: MutableList<String>?):String?{
        return date?.toTypedArray()?.joinToString(",")
    }

}