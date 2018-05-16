package a501.itis.kpfu.ru.itismobileapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import a501.itis.kpfu.ru.itismobileapp.database.entity.Student;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    Student getStudent();

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);
}
