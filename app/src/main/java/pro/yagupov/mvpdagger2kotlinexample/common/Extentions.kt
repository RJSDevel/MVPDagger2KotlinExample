package pro.yagupov.mvpdagger2kotlinexample.common

import android.support.annotation.DrawableRes
import android.text.format.DateUtils
import android.text.format.DateUtils.*
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by developer on 05.06.17.
 */
fun ImageView.setImage(url: String?, @DrawableRes holder: Int) {
    Picasso.with(context)
            .load(url)
            .placeholder(holder)
            .into(this)
}

fun TextView.setPassedTime(createdAt: Long) {
    text = DateUtils.getRelativeTimeSpanString(createdAt * 1000,
            System.currentTimeMillis(),
            DateUtils.MINUTE_IN_MILLIS)
}