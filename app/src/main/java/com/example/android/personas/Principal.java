package com.example.android.personas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //capturar list view

        ls=(ListView)findViewById(R.id.lvopciones);

        //captura de recursos
        res = this.getResources();

        //captura de opciones
        opc = res.getStringArray(R.array.opciones);

        //se crea el adaptador
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);

        //se pasa el adaptador
        ls.setAdapter(adapter);
        //definir evento a listview (cuando le den click algo pasa override)
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        i = new Intent(Principal.this,Registro.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this,Listado.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Principal.this,ListarPersonas.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }
}
