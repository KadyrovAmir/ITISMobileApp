package a501.itis.kpfu.ru.itismobileapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import a501.itis.kpfu.ru.itismobileapp.database.entity.Event;

@Dao
public interface EventDao {
    @Insert
    void insert(Event event);
    @Update
    void update(Event event);
}
