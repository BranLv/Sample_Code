package com.brandon.sqlite_lab;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    StudentDBDataAccessObject studentDBDataAccessObject;
    StudentDBOpenHelper dbs;
    ArrayList<String> namelist;
    ArrayAdapter<String> nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namelist = new ArrayList<String>();
        nameAdapter = new ArrayAdapter<String>(this, R.layout.elementlayout);

        ListView sql = (ListView)findViewById(R.id.studentNameList);
        sql.setAdapter(nameAdapter);
        studentDBDataAccessObject = new StudentDBDataAccessObject(this);
        Button refresh = (Button)findViewById(R.id.buttonRefresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;

                namelist.clear();
                Cursor result;
                result = studentDBDataAccessObject.queryItemAll();
                while (result.moveToNext()){
                    name = result.getString(2);
                    namelist.add(name);

                }
                nameAdapter.notifyDataSetChanged();
            }
        });

    }
}
