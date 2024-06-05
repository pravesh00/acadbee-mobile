package com.example.myapplication.data

import android.os.Parcelable

abstract class File (
    open var title: String,
    open var description: String,
    open var url: String,
    open var thumbnailUrl: String
) : Parcelable