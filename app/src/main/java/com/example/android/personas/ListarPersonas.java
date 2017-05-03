package com.example.android.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPersonas extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personas);

        //Capturar objetos
        lista = (ListView)findViewById(R.id.lvListadoPersonas);
        personas = Datos.getPersonas();

        //Creacion del array adapter de las personas (el creado por nosotros)
        AdaptadorPersona adapter = new AdaptadorPersona(this,personas);
        lista.setAdapter(adapter);



    }
}
