package a501.itis.kpfu.ru.itismobileapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import a501.itis.kpfu.ru.itismobileapp.R;
import a501.itis.kpfu.ru.itismobileapp.fragment.CalendarFragment;

public class MainActivity extends AppCompatActivity {
    int workingFragment;
    private CalendarFragment calendarFragment;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);

        if (savedInstanceState != null){
            workingFragment = savedInstanceState.getInt("workingFragment");
            switch (workingFragment) {
                case 1 :
                    navigation.setSelectedItemId(R.id.navigation_subjects);
                    break;
                case 2 :
                    navigation.setSelectedItemId(R.id.navigation_timetable);
                    break;
                case 3 :
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    break;
            }
        }
        else{
            navigation.setSelectedItemId(R.id.navigation_timetable);
            calendarFragment = new CalendarFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, calendarFragment)
                    .commit();
            workingFragment = 2;
        }

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_subjects:
                        workingFragment = 1;
                        break;
                    case R.id.navigation_timetable:
                        calendarFragment = new CalendarFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container, calendarFragment)
                                .commit();
                        workingFragment = 2;
                        break;
                    case R.id.navigation_notifications:
                        workingFragment = 3;
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("workingFragment", workingFragment);
    }
}
