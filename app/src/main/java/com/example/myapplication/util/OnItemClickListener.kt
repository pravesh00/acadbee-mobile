package com.example.myapplication.util

interface OnItemClickListener<T> {
    fun onItemClick(position: Int, data: T)
}