package a501.itis.kpfu.ru.itismobileapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import a501.itis.kpfu.ru.itismobileapp.R;
import a501.itis.kpfu.ru.itismobileapp.database.AppDataBase;
import a501.itis.kpfu.ru.itismobileapp.database.dao.StudentDao;
import a501.itis.kpfu.ru.itismobileapp.database.entity.Student;
import a501.itis.kpfu.ru.itismobileapp.database.holder.AppDataBaseHolder;

public class LoginActivity extends AppCompatActivity {

    private Spinner group;
    private String[] groups;

    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        groups = new String[]{"501", "502", "503"};

        group = findViewById(R.id.login_group);
        submit = findViewById(R.id.login_submit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, groups);
        group.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (group.getSelectedItem().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Выберите группу!", Toast.LENGTH_SHORT).show();
                }
                else {
                    AppDataBase db = AppDataBaseHolder.getInstance().getDatabase();
                    StudentDao studentDao = db.studentDao();

                    Student thisStudent = new Student();
                    thisStudent.id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                    thisStudent.group = group.getSelectedItem().toString();

                    studentDao.insert(thisStudent);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
