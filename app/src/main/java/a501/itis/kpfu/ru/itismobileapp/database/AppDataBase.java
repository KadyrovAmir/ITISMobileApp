package a501.itis.kpfu.ru.itismobileapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import a501.itis.kpfu.ru.itismobileapp.database.dao.StudentDao;
import a501.itis.kpfu.ru.itismobileapp.database.entity.Event;
import a501.itis.kpfu.ru.itismobileapp.database.entity.Student;

@Database(entities = {Student.class, Event.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
