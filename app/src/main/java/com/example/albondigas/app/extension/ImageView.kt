package com.example.albondigas.app.extension

import android.media.Image
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(url:String){
    Glide.with(this.context).load(url).into(this)
}