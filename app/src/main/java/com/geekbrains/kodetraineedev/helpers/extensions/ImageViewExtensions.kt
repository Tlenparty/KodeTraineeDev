package com.geekbrains.kodetraineedev.helpers.extensions

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

fun ImageView.setDrawableCircleImageFromUri(url: String, container: ImageView) {
    Glide.with(container.context)
        .asBitmap()
        .load(url)
        .apply(
            RequestOptions
                .circleCropTransform()
                .override(72.dp(container.context))
        )
        .listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Bitmap>?,
                isFirstResource: Boolean
            ): Boolean {
                //Обработка провала загрузки
                return false
            }

            override fun onResourceReady(
                resource: Bitmap?,
                model: Any?,
                target: Target<Bitmap>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                //Делаем что-то с Bitmap
                return false
            }


        })
        .into(container)
}


