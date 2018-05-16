package a501.itis.kpfu.ru.itismobileapp.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.github.gfranks.collapsible.calendar.model.CollapsibleCalendarEvent;

import org.joda.time.LocalDate;

@Entity
public class Event extends CollapsibleCalendarEvent {

    @NonNull
    @PrimaryKey
    public String id;
    public String mTitle;
    public long mDate;

    public Event(String mTitle, long mDate) {
        this.id = "NONE";
        this.mTitle = mTitle;
        this.mDate = mDate;
    }

    @Override
    public LocalDate getCollapsibleEventLocalDate() {
        return new LocalDate(mDate);
    }
}
