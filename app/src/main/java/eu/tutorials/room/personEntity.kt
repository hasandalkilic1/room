package eu.tutorials.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "person" )
data class personEntity(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name="id") @NotNull var id:Int,
                        @ColumnInfo(name="name") @NotNull var name:String,
                        @ColumnInfo(name="age") @NotNull var age:Int) {
}