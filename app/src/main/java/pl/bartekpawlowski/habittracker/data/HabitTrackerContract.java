package pl.bartekpawlowski.habittracker.data;

import android.provider.BaseColumns;

/**
 * Contract class for HabitTracker app
 */

public final class HabitTrackerContract {

    /**
     * Private constructor to avoid accidentally call HabitTrackerContract class
     */
    private HabitTrackerContract() {};

    public static class HabitTrackerEntry implements BaseColumns {
        // Table name
        public final static String TABLE_NAME = "habbit_tracker";

        // Columns names
        public final static String _ID = BaseColumns._ID;
        public final static String HABIT_NAME = "habit_name";
        public final static String HABIT_START_TIME = "habit_start_time";
        public final static String HABIT_DURATION = "habit_duration";
        public final static String IS_HABIT_FINISHED = "is_habit_finished";

        // HABIT_FINISHED states
        public final static int HABIT_NOT_FINISHED = 0;
        public final static int HABIT_FINISHED = 1;
    }
}
