package a501.itis.kpfu.ru.itismobileapp.database.holder;

import android.app.Application;
import android.arch.persistence.room.Room;

import a501.itis.kpfu.ru.itismobileapp.database.AppDataBase;

public class AppDataBaseHolder extends Application {

    public static AppDataBaseHolder instance;

    private AppDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "local_itis_database")
                .allowMainThreadQueries()
                .build();
    }

    public static AppDataBaseHolder getInstance() {
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }
}
