package com.brandon.sqlite_lab;

import android.provider.BaseColumns;

/**
 * Created by user on 4/11/2018.
 */

public class StudentDBContract {
    private StudentDBContract(){}
    public static final  int    DATABASE_VERSION   = 1;
    public static final  String DATABASE_NAME      = "school.db";
    private static final String TEXT_TYPE          = " TEXT";
    private static final String COMMA_SEP          = ",";
    private static final String INT_TYPE           = "INTEGER";

    public static class StudentsTable implements BaseColumns {
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME_FIRST = "first";
        public static final String COLUMN_NAME_LAST = "last";
        public static final String COLUMN_NAME_CREDITS = "credits";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME+ "(" +
                _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                COLUMN_NAME_FIRST + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_LAST +TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_CREDITS+INT_TYPE+")";

public static final String DELETE_TABLE = "DROP TABLE IF EXIST" + TABLE_NAME;

    }
}
