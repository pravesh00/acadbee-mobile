package com.example.myapplication.data

import android.os.Parcel
import android.os.Parcelable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coursefile")
data class CourseFile(
    @PrimaryKey(autoGenerate = true)override var id: Int = 0,
    @ColumnInfo(name = "title") override var title: String,
    @ColumnInfo(name = "description") override var description: String,
    @ColumnInfo(name = "url") override var url: String,
    @ColumnInfo(name = "thumbnailUrl") override var thumbnailUrl: String,
    @ColumnInfo(name = "instructorUserName") var instructorUserName: String = "",
    @ColumnInfo(name = "courseName") var courseName: String? = null
) : File(id, title, description, url, thumbnailUrl), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString()
    )
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(instructorUserName)
        parcel.writeString(courseName)
    }

    companion object CREATOR : Parcelable.Creator<CourseFile> {
        override fun createFromParcel(parcel: Parcel): CourseFile {
            return CourseFile(parcel)
        }

        override fun newArray(size: Int): Array<CourseFile?> {
            return arrayOfNulls(size)
        }
    }
}
