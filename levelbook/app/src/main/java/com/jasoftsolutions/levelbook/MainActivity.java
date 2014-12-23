package com.jasoftsolutions.levelbook;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private final static String TAG = "Debug Main Activity";
    private  Integer numero1, numero2;
    private static Integer numeroEjercicio, intentos ;
    private  String stringNumeroEjercicio;
    private  TextView tvNumero1, tvNumero2, tvNumeroEjercicio;
    private  EditText etRespuesta;


    public final static String NUMBER_EXERCISE = "numeroEjercicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroEjercicio = 1;
        intentos = 1;
        numero1 = (int) (Math.random() * 12);
        numero2 = (int) (Math.random() * 5);

        stringNumeroEjercicio = getResources().getString(R.string.tvNumeroEjercicio) + " " + numeroEjercicio.toString();

        tvNumeroEjercicio = (TextView) findViewById(R.id.tvNumeroEjercicio);
        tvNumeroEjercicio.setText(stringNumeroEjercicio);

        tvNumero1 = (TextView) findViewById(R.id.tvNumero1);
        tvNumero2 = (TextView) findViewById(R.id.tvNumero2);

        tvNumero1.setText(numero1.toString());
        tvNumero2.setText(numero2.toString());

        Button btVerificar = (Button) findViewById(R.id.btVerificar);

        etRespuesta = (EditText) findViewById(R.id.etRespuesta);

        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etRespuesta.getText().toString() != null &&  (!etRespuesta.getText().toString().isEmpty())){
                    Integer resultado, respuesta;

                    resultado = numero1 * numero2;
                    respuesta = Integer.parseInt(etRespuesta.getText().toString());
                    if(resultado == respuesta){

                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.good), Toast.LENGTH_SHORT).show();

                        etRespuesta.setText("");
                        numeroEjercicio++;

                        stringNumeroEjercicio = getResources().getString(R.string.tvNumeroEjercicio) + " " + numeroEjercicio.toString();
                        tvNumeroEjercicio.setText(stringNumeroEjercicio);

                        numero1 = (int) (Math.random()*12);
                        numero2 = (int) (Math.random()*5);

                        tvNumero1.setText(numero1.toString());
                        tvNumero2.setText(numero2.toString());


                    }
                    else{
                        intentos++;

                        if(intentos>=4){
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.numberIntents), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), InfoUserActivity.class);
                            Bundle b = new Bundle();
                            intentos--;
                            stringNumeroEjercicio = getResources().getString(R.string.tvNumeroEjercicio) + " " + numeroEjercicio.toString();
                            tvNumeroEjercicio.setText(stringNumeroEjercicio);
                            etRespuesta.setText("");
                            b.putString(NUMBER_EXERCISE, numeroEjercicio.toString());
                            i.putExtras(b);
                            startActivity(i);
                            numeroEjercicio = 1;
                            intentos = 1;

                        }
                        else{
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.bad), Toast.LENGTH_SHORT).show();
                        }


                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.insertNumber), Toast.LENGTH_SHORT).show();
                }


            }
        });

        //Toast.makeText(getBaseContext(), numeroEjercicio, Toast.LENGTH_LONG).show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_exit) {

        //    finish();
        //    return true;
        //}

        switch (id){
            case R.id.action_records:
                Intent i = new Intent(getApplicationContext(), RecordsActivity.class);
                startActivity(i);
                break;
            case R.id.action_about:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.about),Toast.LENGTH_LONG).show();
                //return true;
                break;
            case R.id.action_exit:
                finish();
                //return true;
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
