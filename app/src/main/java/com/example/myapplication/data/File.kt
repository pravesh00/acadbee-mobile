package com.example.myapplication.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "file")
abstract class File (
    @PrimaryKey(autoGenerate = true) open var id: Int = 0,
    @ColumnInfo(name = "title") open var title: String,
    @ColumnInfo(name = "description") open var description: String,
    @ColumnInfo(name = "url") open var url: String,
    @ColumnInfo(name = "thumbnailUrl") open var thumbnailUrl: String
): Parcelable
