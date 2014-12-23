package com.jasoftsolutions.levelbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InfoUserActivity extends ActionBarActivity {

    public final static String TAG_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);

        final EditText etName = (EditText) findViewById(R.id.et_name);
        final EditText etLasName = (EditText) findViewById(R.id.et_lastName);
        final EditText etSchool = (EditText) findViewById(R.id.et_school);
        Button btSave = (Button) findViewById(R.id.btSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingrese al menos su nombre", Toast.LENGTH_SHORT).show();
                }
                else {
                    String sendString = etName.getText().toString() + " " + etLasName.getText().toString() + " - " + etSchool.getText().toString();
                    Intent in = getIntent();
                    String numberExercise = in.getStringExtra(MainActivity.NUMBER_EXERCISE);

                    Intent i = new Intent(getApplicationContext(), RecordsActivity.class);
                    Bundle b = new Bundle();

                    b.putString(TAG_NAME, etName.getText().toString());
                    i.putExtras(b);

                    b.putString(MainActivity.NUMBER_EXERCISE, numberExercise);
                    i.putExtras(b);
                    startActivity(i);
                }


            }
        });
    }



}
