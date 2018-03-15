package in.gov.py.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sam on 8/3/18.
 */

public class highlightHoliday implements DayViewDecorator {
    private final HashSet<CalendarDay> dates;
    private final Drawable highlightDrawable;
    private static final int color= Color.parseColor("#FF0000");

    public highlightHoliday(Collection<CalendarDay> dates){
        this.dates=new HashSet<>(dates);
        highlightDrawable = new ColorDrawable(color);
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {

        //view.setBackgroundDrawable(highlightDrawable);
        view.addSpan(new mySpan(50,color));
    }
}
