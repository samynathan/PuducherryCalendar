package in.gov.py.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    MaterialCalendarView widget;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialCalendarView materialCalendarView=(MaterialCalendarView) findViewById(R.id.calendarView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017,11,01))
                .setMaximumDate(CalendarDay.from(2019,0,31)).commit();
        final ArrayList<CalendarDay> holiday= new ArrayList<CalendarDay>();
        ArrayList<CalendarDay> rHDay= new ArrayList<CalendarDay>();

        holiday.add(CalendarDay.from(2018,0,01));
        holiday.add(CalendarDay.from(2018,0,15));
        rHDay.add(CalendarDay.from(2018,0,16));
        holiday.add(CalendarDay.from(2018,0,26));

        rHDay.add(CalendarDay.from(2018,1,14));

        rHDay.add(CalendarDay.from(2018,2,01));
        rHDay.add(CalendarDay.from(2018,2,02));
        rHDay.add(CalendarDay.from(2018,2,19));
        rHDay.add(CalendarDay.from(2018,2,29));
        holiday.add(CalendarDay.from(2018,2,30));

        rHDay.add(CalendarDay.from(2018,3,02));
        rHDay.add(CalendarDay.from(2018,3,13));
        rHDay.add(CalendarDay.from(2018,3,25));
        rHDay.add(CalendarDay.from(2018,3,30));

        holiday.add(CalendarDay.from(2018,4,01));

        rHDay.add(CalendarDay.from(2018,5,11));
        rHDay.add(CalendarDay.from(2018,5,12));
        holiday.add(CalendarDay.from(2018,5,15));
        rHDay.add(CalendarDay.from(2018,5,27));

        holiday.add(CalendarDay.from(2018,7,15));
        holiday.add(CalendarDay.from(2018,7,16));
        rHDay.add(CalendarDay.from(2018,7,17));
        holiday.add(CalendarDay.from(2018,7,22));
        rHDay.add(CalendarDay.from(2018,7,24));
        rHDay.add(CalendarDay.from(2018,7,27));

        holiday.add(CalendarDay.from(2018,8,13));
        rHDay.add(CalendarDay.from(2018,8,19));
        rHDay.add(CalendarDay.from(2018,8,21));

        holiday.add(CalendarDay.from(2018,9,02));
        rHDay.add(CalendarDay.from(2018,9,15));
        holiday.add(CalendarDay.from(2018,9,18));
        rHDay.add(CalendarDay.from(2018,9,19));

        holiday.add(CalendarDay.from(2018,10,01));
        rHDay.add(CalendarDay.from(2018,10,02));
        rHDay.add(CalendarDay.from(2018,10,05));
        holiday.add(CalendarDay.from(2018,10,06));
        holiday.add(CalendarDay.from(2018,10,21));
        rHDay.add(CalendarDay.from(2018,10,23));

        rHDay.add(CalendarDay.from(2018,11,24));
        holiday.add(CalendarDay.from(2018,11,25));

        //materialCalendarView.addDecorator(new highlightHoliday(holiday));
        //materialCalendarView.addDecorator(new highrestrictedHoliday(this,rHDay));
        //materialCalendarView.addDecorator(new highlightWeekend());
        materialCalendarView.addDecorator(new highlightHoliday(holiday));
        materialCalendarView.addDecorator(new highrestrictedHoliday(this,rHDay));
        materialCalendarView.addDecorator(new highlightWeekend());
        materialCalendarView.addDecorator(new EventDecorator());
        materialCalendarView.setDateTextAppearance(R.style.customDayTextAppearance);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                String holidayReason="";

                if (date.equals(CalendarDay.from(2018,0,01))){
                    holidayReason="New Year";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,0,15))){
                    holidayReason="Thiruvalluvar Day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,0,16))){
                    holidayReason="Uzhavar Thirunal";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,0,26))){
                    holidayReason="Republic Day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,1,14))){
                    holidayReason="Maha Sivarathri";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,2,01))){
                    holidayReason="Vishnu Car Festival (Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,2,02))){
                    holidayReason="Masi magam";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,2,19))){
                    holidayReason="Feast of St. Joseph";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,2,29))){
                    holidayReason="Maundy Thursday/Mahavir Jayanthi/ Sri Kailasanatha Temple Car Festival";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,2,30))){
                    holidayReason="Good Friday";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,3,02))){
                    holidayReason="Easter Monday";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,3,13))){
                    holidayReason="Sri Rama Navami";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,3,25))){
                    holidayReason="Kandhoori Festival (Karaikal)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,3,30))){
                    holidayReason="Buddha Poornima";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,4,01))){
                    holidayReason="Shab-e-barath";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,5,11))){
                    holidayReason="Lailathul qadar (Mahe)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,5,12))){
                    holidayReason="Lailathul qadar (Puducherry/Karaikal/Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,5,15))){
                    holidayReason="Ramzan(id-ul-fitr)(Puducherry/Yanam/Karaikal)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,5,27))){
                    holidayReason="Mangani Festival";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,15))){
                    holidayReason="Independence Day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,16))){
                    holidayReason="The De-jure transfer day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,17))){
                    holidayReason="Veerampatinam Car Festival";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,22))){
                    holidayReason="Bakrid(id-ul-alha)(Puducherry/Karaikal/Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,24))){
                    holidayReason="onam first day (Mahe)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,7,27))){
                    holidayReason="Sri Narayan Guru Jayanthi";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,8,13))){
                    holidayReason="Vinayagar Chathurthi (Puducherry/Karaikal/Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,8,19))){
                    holidayReason="Muharram (ashura day) (Mahe)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,8,21))){
                    holidayReason="Sri Narayana Guru Samadhi/Muharram (ashura day) - Puducherry/Karaikal/Yanam";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,9,02))){
                    holidayReason="Gandhi Jayanthi";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,9,15))){
                    holidayReason="St.Theresa Festival(Puducherry/Karaikal/Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,9,18))){
                    holidayReason="Saraswathi Pooja/Ayudha Pooja Puducherry/Karaikal/Yanam , Saraswathi Pooja/Maha Navami (Mahe)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,9,19))){
                    holidayReason="Vijayadhasami";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,01))){
                    holidayReason="Puducherry Liberation Day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,02))){
                    holidayReason="All Souls Day";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,05))){
                    holidayReason="Deepawali Eve";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,06))){
                    holidayReason="Deepawali (Puducherry/Karaikal/Yanam) ";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,21))){
                    holidayReason="Milad-un-nabi(or)id-e-milad (Puducherry/Karaikal/Yanam)";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,10,23))){
                    holidayReason="Guru Nanank's Birthday/Karthigaideepam";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }

                if (date.equals(CalendarDay.from(2018,11,24))){
                    holidayReason="Christmas Eve";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }
                if (date.equals(CalendarDay.from(2018,11,25))){
                    holidayReason="Christmas";
                    Toast.makeText(MainActivity.this,holidayReason,Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

}


