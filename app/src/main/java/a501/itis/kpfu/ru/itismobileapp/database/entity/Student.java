package a501.itis.kpfu.ru.itismobileapp.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Student {
    @NonNull
    @PrimaryKey
    public String id;
    public String group;
    public long lab;
    public long course;
}
