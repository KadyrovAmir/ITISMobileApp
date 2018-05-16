package a501.itis.kpfu.ru.itismobileapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.gfranks.collapsible.calendar.CollapsibleCalendarView;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import a501.itis.kpfu.ru.itismobileapp.R;
import a501.itis.kpfu.ru.itismobileapp.database.entity.Event;


public class CalendarFragment extends Fragment implements CollapsibleCalendarView.Listener<Event>{

    private CollapsibleCalendarView mCalendarView;
    private ListView mListView;
    private EventListAdapter mAdapter;

    public CalendarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCalendarView = (CollapsibleCalendarView) view.findViewById(R.id.calendar);
        mListView = (ListView) view.findViewById(R.id.calendar_event_list);

        mCalendarView.setListener(this);
        mCalendarView.addEvents(getEvents());
    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        for (int i=0; i<20; i++) {
            events.add(new Event("Event " + (i+1), System.currentTimeMillis() + (86400000 * i)));
        }
        return events;
    }

    @Override
    public void onDateSelected(LocalDate localDate, List<Event> events) {
        if (mAdapter == null || mListView.getAdapter() == null) {
            mAdapter = new EventListAdapter(getContext(), events);
            mListView.setAdapter(mAdapter);
        } else {
            mAdapter.setEvents(events);
        }
    }

    @Override
    public void onMonthChanged(LocalDate localDate) {

    }

    @Override
    public void onHeaderClick() {

    }

    private class EventListAdapter extends ArrayAdapter<String> {

        public final DateTimeFormatter mTimeFormat = DateTimeFormat.forPattern(" h:mm a");
        private List<Event> mEvents;

        public EventListAdapter(Context context, List<Event> events) {
            super(context, android.R.layout.simple_list_item_1);
            mEvents = events;
        }

        public void setEvents(List<Event> events) {
            mEvents = events;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mEvents.size();
        }

        @Override
        public String getItem(int position) {
            Event event = mEvents.get(position);
            return mTimeFormat.print(new DateTime(event.mDate)) + " - " + event.mTitle;
        }
    }
}
