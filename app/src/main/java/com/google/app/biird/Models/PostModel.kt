package com.google.app.biird.Models

class PostModel {
    val img:Int
    val caption:String

    constructor(img: Int, caption: String) {
        this.img = img
        this.caption = caption
    }
}