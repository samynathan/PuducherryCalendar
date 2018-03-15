package in.gov.py.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sam on 8/3/18.
 */

class highrestrictedHoliday implements DayViewDecorator {
    private final HashSet<CalendarDay> dates;
    private final Drawable highlightDrawable;
    private static final int color= Color.parseColor("#008000");

    public highrestrictedHoliday(Context context, Collection<CalendarDay> dates) {
        this.dates=new HashSet<>(dates);
        //highlightDrawable = new ColorDrawable(color);
        highlightDrawable = context.getResources().getDrawable(R.drawable.shape);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        //view.setBackgroundDrawable(highlightDrawable);
        //view.setSelectionDrawable(highlightDrawable);
        view.addSpan(new mySpan(50,color));
    }
}
