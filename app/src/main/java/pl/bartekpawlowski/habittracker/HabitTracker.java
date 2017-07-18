package pl.bartekpawlowski.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.bartekpawlowski.habittracker.data.HabitTrackerDbHelper;

public class HabitTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Instance of HabitTrackerDbHelper
    private HabitTrackerDbHelper mDbHelper;

    // Method to insert data into SQLight table
    public void insertHabit() {

    }

    // Method to get Cursor
    public Cursor getCursor() {
        Cursor cursor =  null;

        return cursor;
    }

    // Method to display data for database
    public void displayHabits() {

    }
}
