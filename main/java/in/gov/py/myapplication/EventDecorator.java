package in.gov.py.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sam on 7/3/18.
 */

public class EventDecorator implements DayViewDecorator {
    private final int color= Color.parseColor("#7E57C2");
    Calendar today = Calendar.getInstance();
    public EventDecorator(){
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(CalendarDay.today());
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new mySpan(40,color));
    }
}
