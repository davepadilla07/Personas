package com.example.android.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    private TableLayout tabla;
    private String aux;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //capturar la tabla
        tabla=(TableLayout)findViewById(R.id.tblPersonas);
        personas = Datos.traerPersonas(getApplicationContext());

        //recorrer el vector de personas e ir mostrando en pantalla
        for (int i = 0; i < personas.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
             //que va en cada columna
            c1.setText(""+(i+1));
            c2.setText(personas.get(i).getNombre());
            c3.setText(personas.get(i).getApellido());
            c4.setText(personas.get(i).getPasatiempos());

            //agregar textview a las filas
            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            //decirle al table que vamos a agregar las filas
            tabla.addView(fila);



        }


    }
}
