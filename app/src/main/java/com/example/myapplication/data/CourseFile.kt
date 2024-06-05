package com.example.myapplication.data

import android.os.Parcel
import android.os.Parcelable


data class CourseFile(
    override var title: String,
    override var description: String,
    override var url: String,
    override var thumbnailUrl: String,
    var instructorUserName: String = "",
    var courseName: String? = null
) : File(title, description, url, thumbnailUrl), Parcelable {

    constructor(parcel: Parcel) : this(
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