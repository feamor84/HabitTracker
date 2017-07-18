package pl.bartekpawlowski.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pl.bartekpawlowski.habittracker.data.HabitTrackerContract.HabitTrackerEntry;

/**
 * Class creates new database or upgrade existing one
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "HabitTracker.db";
    private final static int DB_VERSION = 1;

    private final static String CREATE_DB = "CREATE TABLE " + HabitTrackerEntry.TABLE_NAME + " (" +
            HabitTrackerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            HabitTrackerEntry.HABIT_NAME + " TEXT NOT NULL, " +
            HabitTrackerEntry.HABIT_START_TIME + " INTEGER NOT NULL, " +
            HabitTrackerEntry.HABIT_DURATION + " INTEGER NOT NULL, " +
            HabitTrackerEntry.IS_HABIT_FINISHED + " INTEGER NOT NULL DEFAULT " + HabitTrackerEntry.HABIT_NOT_FINISHED + " );";
    private final static String DROP_DB = "DROP TABLE IF EXISTS " + HabitTrackerEntry.TABLE_NAME;

    public HabitTrackerDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    };

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_DB);
    }

    /**
     * @param name
     * @param start
     * @param duration
     * @param isFinished
     */
    public void insertHabit(String name, int start, int duration, int isFinished) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitTrackerEntry.HABIT_NAME, name);
        contentValues.put(HabitTrackerEntry.HABIT_START_TIME, start);
        contentValues.put(HabitTrackerEntry.HABIT_DURATION, duration);
        contentValues.put(HabitTrackerEntry.IS_HABIT_FINISHED, isFinished);

        sqLiteDatabase.insert(HabitTrackerEntry.TABLE_NAME, null, contentValues);
    }

    /**
     * Method @return all records from habit table
     */
    public Cursor getAllHabits() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        return sqLiteDatabase.query(HabitTrackerEntry.TABLE_NAME, null, null, null, null, null, null);
    }
}
