package com.jasoftsolutions.levelbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class RecordsActivity extends ActionBarActivity {

    private static final ArrayList<String> names = new ArrayList<String>();
    //public String name;

    private final static String TAG = "Debug Records Activity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        Intent i = getIntent();
        String name = i.getStringExtra(InfoUserActivity.TAG_NAME);
        String numberExercise = i.getStringExtra(MainActivity.NUMBER_EXERCISE);



        ListView list = (ListView)findViewById(R.id.lv_users);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, names);

        list.setAdapter(adapter);
        if(!names.contains(name) && !name.isEmpty()){
            name = name + " " + numberExercise;
            names.add(name);
            adapter.notifyDataSetChanged();
        }

        Button bt_backHome = (Button) findViewById(R.id.bt_backHome);
        bt_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }


}
