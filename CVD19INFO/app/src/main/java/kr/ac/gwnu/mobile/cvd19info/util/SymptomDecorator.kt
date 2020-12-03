package kr.ac.gwnu.mobile.cvd19info.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import kr.ac.gwnu.mobile.cvd19info.R


class SymptomDecorator(private val context: Context, private val dates: CalendarDay) : DayViewDecorator {
        private val drawable: Drawable?
        var myDay = dates
        override fun shouldDecorate(day: CalendarDay): Boolean {
            return day == myDay
        }

        override fun decorate(view: DayViewFacade) {
            view.setSelectionDrawable(drawable!!)
        }

        init {
            // You can set background for Decorator via drawable here
            drawable = ContextCompat.getDrawable(context!!, R.drawable.red_circle)
        }
}