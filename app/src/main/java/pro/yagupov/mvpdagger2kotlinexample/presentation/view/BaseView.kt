package pro.yagupov.mvpdagger2kotlinexample.presentation.view

import android.content.Context
import android.os.Bundle

/**
 * Created by developer on 30.05.17.
 */
interface BaseView {

    fun show(contex : Context, arguments : Bundle? = null)

}