package com.jasoftsolutions.levelbook;

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

    private final static String TAG = "Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer numeroEjercicio = 1;
        final Integer numero1 = (int) (Math.random() * 10);
        final Integer numero2 = (int) (Math.random() * 10);

        String stringNumeroEjercicio = getResources().getString(R.string.tvNumeroEjercicio) + " " + numeroEjercicio.toString();

        TextView tvNumeroEjercicio = (TextView) findViewById(R.id.tvNumeroEjercicio);
        tvNumeroEjercicio.setText(stringNumeroEjercicio);

        TextView tvNumero1 = (TextView) findViewById(R.id.tvNumero1);
        TextView tvNumero2 = (TextView) findViewById(R.id.tvNumero2);

        tvNumero1.setText(numero1.toString());
        tvNumero2.setText(numero2.toString());

        Button btVerificar = (Button) findViewById(R.id.btVerificar);

        final EditText etRespuesta = (EditText) findViewById(R.id.etRespuesta);

        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.e(TAG, etRespuesta.getText().toString());

                if(etRespuesta.getText().toString() != null &&  (!etRespuesta.getText().toString().isEmpty())){
                    Integer resultado, respuesta;

                    resultado = numero1 * numero2;
                    respuesta = Integer.parseInt(etRespuesta.getText().toString());
                    if(resultado == respuesta){
                        Toast.makeText(getApplicationContext(), "Bien", Toast.LENGTH_SHORT).show();
                    /*
                    numeroEjercicio++;

                    stringNumeroEjercicio = getResources().getString(R.string.tvNumeroEjercicio) + " " + numeroEjercicio[0].toString();
                    tvNumeroEjercicio.setText(stringNumeroEjercicio);

                    numero1 = (int) (Math.random()*10);
                    numero2 = (int) (Math.random()*10);

                    tvNumero1.setText(numero1[0].toString());
                    tvNumero2.setText(numero2[0].toString());
                    */

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Mal", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Ingrese Número", Toast.LENGTH_SHORT).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
