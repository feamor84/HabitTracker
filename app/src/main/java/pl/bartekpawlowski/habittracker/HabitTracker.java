package pl.bartekpawlowski.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import pl.bartekpawlowski.habittracker.data.HabitTrackerContract.HabitTrackerEntry;
import pl.bartekpawlowski.habittracker.data.HabitTrackerDbHelper;

public class HabitTracker extends AppCompatActivity {

    // Tag for logging
    private static final String LOG_TAG = HabitTracker.class.getSimpleName();

    // Instance of HabitTrackerDbHelper
    private HabitTrackerDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDbHelper = new HabitTrackerDbHelper(this);

        mDbHelper.insertHabit("Running", 1500369231, 1500412431, 0);
        mDbHelper.insertHabit("Walk with dog", 1500412431, 1500413631, 0);

        displayHabits();
    }

    // Method to display data for database
    public void displayHabits() {
        Cursor results = mDbHelper.getAllHabits();

        try {
            int nameColumnIndex = results.getColumnIndex(HabitTrackerEntry.HABIT_NAME);
            int startTimeColumnIndex = results.getColumnIndex(HabitTrackerEntry.HABIT_START_TIME);
            int durationColumnIndex = results.getColumnIndex(HabitTrackerEntry.HABIT_DURATION);
            int isFinishedColumnIndex = results.getColumnIndex(HabitTrackerEntry.IS_HABIT_FINISHED);

            while (results.moveToNext()) {
                Log.i(LOG_TAG,
                        "Habit: "
                                + results.getString(nameColumnIndex) + ", "
                                + results.getInt(startTimeColumnIndex) + ", "
                                + results.getInt(durationColumnIndex) + ", "
                                + results.getInt(isFinishedColumnIndex) + "\n"
                );
            }
        } finally {
            results.close();
        }
    }
}
