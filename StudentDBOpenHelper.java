package com.brandon.sqlite_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by user on 4/11/2018.
 */

public class StudentDBOpenHelper extends SQLiteOpenHelper {
    public StudentDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override public void onCreate(SQLiteDatabase db){
        db.execSQL(StudentDBContract.StudentsTable.CREATE_TABLE);



        ContentValues rowData = new ContentValues();
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_FIRST, "Jane");
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_LAST, "Doe");
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_CREDITS, "100");
        db.insert(StudentDBContract.StudentsTable.TABLE_NAME, null, rowData);

        rowData = new ContentValues();
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_FIRST, "John");
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_LAST, "Smith");
        rowData.put(StudentDBContract.StudentsTable.COLUMN_NAME_CREDITS, "25");

        db.insert(StudentDBContract.StudentsTable.TABLE_NAME, null, rowData);

    }
    @Override public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){

    }
}
