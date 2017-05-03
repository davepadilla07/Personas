package com.example.android.personas;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private EditText nomb, apell, edad;
    private CheckBox leer, bailar, programar;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        res = this.getResources();

        //capturar nombre
        nomb = (EditText)findViewById(R.id.txtNombre);

        //capturar apellido
        apell = (EditText)findViewById(R.id.txtApellido);

        //capturar edad
        edad = (EditText)findViewById(R.id.txtEdad);

        //capturar checkboss
        leer = (CheckBox)findViewById(R.id.chkLeer);
        bailar = (CheckBox)findViewById(R.id.chkBailar);
        programar = (CheckBox)findViewById(R.id.chkProgramar);



    }

    //programar evento (edad se pone como string por que no se haran calculos con ella)

    public void registrar(View v){

        if (validar()) {

            String nombre, apellido, aux = "", foto;
            int ed;
            nombre = nomb.getText().toString().trim();
            apellido = apell.getText().toString().trim();
            ed = Integer.parseInt(edad.getText().toString().trim());

            if (leer.isChecked()) {
                aux = res.getString(R.string.leer);
            }
            if (bailar.isChecked()) {
                aux = aux + ", " + res.getString(R.string.bailar);
            }
            if (programar.isChecked()) {
                aux = aux + ", " + res.getString(R.string.programar);
            }

            //lo anterior se hace asi en USA
        /*
        if(leer.isChecked()) aux = res.getString(R.string.leer);
        if(bailar.isChecked()) aux = aux+", "+res.getString(R.string.bailar);
        if(programar.isChecked()) aux = aux+", "+res.getString(R.string.programar);
        */
            foto = String.valueOf(fotoAleatoria());

            Persona p = new Persona(foto, nombre, apellido, ed, aux);
            p.guardar();

            //poner un mensaje
            new AlertDialog.Builder(this).setTitle("Aceptar").setMessage(res.getString(R.string.mensaje)).show();
            limpiar();
        }
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        nomb.setText("");
        apell.setText("");
        edad.setText("");
        leer.setChecked(true);
        bailar.setChecked(false);
        programar.setChecked(false);
        nomb.requestFocus();
    }

    public boolean validar(){
        if (nomb.getText().toString().isEmpty()){
            nomb.setError(getResources().getString(R.string.error1));
            return false;
        }
        if (apell.getText().toString().isEmpty()){
            apell.setError(getResources().getString(R.string.error2));
            return false;
        }
        if (edad.getText().toString().isEmpty()){
            edad.setError(getResources().getString(R.string.error3));
            return false;
        }


        return true;
    }

    //Metodo aleatorio
    public int fotoAleatoria(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int)(Math.random() *2);
        return fotos[numero];
    }

}
