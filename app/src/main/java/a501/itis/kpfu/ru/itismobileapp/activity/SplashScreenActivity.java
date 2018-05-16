package a501.itis.kpfu.ru.itismobileapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import a501.itis.kpfu.ru.itismobileapp.database.AppDataBase;
import a501.itis.kpfu.ru.itismobileapp.database.dao.StudentDao;
import a501.itis.kpfu.ru.itismobileapp.database.holder.AppDataBaseHolder;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Toast.makeText(this, "Can't make thread sleep", Toast.LENGTH_SHORT).show();
        }
        AppDataBase db = AppDataBaseHolder.getInstance().getDatabase();
        StudentDao studentDao = db.studentDao();

        Intent intent;

        if (studentDao.getStudent() != null)
            intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        else
            intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
