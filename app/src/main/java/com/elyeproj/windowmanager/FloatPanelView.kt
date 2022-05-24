package com.elyeproj.windowmanager

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.WindowManager

class FloatPanelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FloatView(context, attrs, defStyleAttr) {

    var zIndex =0
    init {
        Log.d("FloatPanelView", "x is ${ZIndex.x}")
        zIndex = ZIndex.current()
    }

    override val type: Int
        // TYPE_APPLICATION_SUB_PANEL is always on top of TYPE_APPLICATION_PANEL
        get() = if(ZIndex.current()==1) WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL else WindowManager.LayoutParams.TYPE_APPLICATION_PANEL

}

object ZIndex{
    var x = 0

    fun current(): Int {
        synchronized(this) {
            x += 1
            return x
        }
    }

}