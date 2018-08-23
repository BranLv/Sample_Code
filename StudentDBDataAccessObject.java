package com.brandon.sqlite_lab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 4/16/2018.
 */

public class StudentDBDataAccessObject {
    StudentDBOpenHelper dbhelper;
    public StudentDBDataAccessObject(Context context) {
        dbhelper = new StudentDBOpenHelper(context, StudentDBContract.DATABASE_NAME, null, 1);    }
    public Cursor queryItemAll() {
        SQLiteDatabase db;
        Cursor resultCursor;
        String[] resultColumns = new String[]{
                StudentDBContract.StudentsTable._ID,
                StudentDBContract.StudentsTable.COLUMN_NAME_FIRST,
                StudentDBContract.StudentsTable.COLUMN_NAME_LAST
        };

        db = dbhelper.getWritableDatabase();
        resultCursor = db.query(StudentDBContract.StudentsTable.TABLE_NAME,resultColumns, null, null, null, null, null);
        // Handy helper function
        return resultCursor;
}
    }
