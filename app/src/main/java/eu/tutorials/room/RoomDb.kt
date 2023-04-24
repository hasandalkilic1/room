package eu.tutorials.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [personEntity::class], version = 1)
abstract class RoomDb:RoomDatabase() {
    abstract fun getPersonDao():personDao

    companion object{
        var INSTANCE:RoomDb?=null

        fun accessDb(context: Context):RoomDb?{
            if(INSTANCE==null){
                synchronized(RoomDb::class){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                        RoomDb::class.java,
                        "rehber.sqlite")
                        .createFromAsset("rehber.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}