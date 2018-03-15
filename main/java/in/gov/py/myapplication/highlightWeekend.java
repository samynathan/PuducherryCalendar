package in.gov.py.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;

import static android.hardware.camera2.params.RggbChannelVector.BLUE;
import static android.hardware.camera2.params.RggbChannelVector.RED;

/**
 * Created by sam on 8/3/18.
 */

public class highlightWeekend implements DayViewDecorator {

    private final Calendar calendar=Calendar.getInstance();
    private final Drawable highlightDrawable;
    private static final int color= Color.parseColor("#FF0000");

    public highlightWeekend() {

        highlightDrawable = new ColorDrawable(color);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay==Calendar.SATURDAY || weekDay==Calendar.SUNDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        //view.setBackgroundDrawable(highlightDrawable);
        view.addSpan(new mySpan(50,color));

    }
}
