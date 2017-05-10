package com.example.android.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {


    public static ArrayList<Persona> traerPersonas(Context contexto){

        //Declarar variables
        SQLiteDatabase db;
        String sql,foto,nombre,apellido,pasatiempo;
        int edad;
        ArrayList<Persona> personas=new ArrayList();

        //Abrir la base de datos de lectura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
        db=aux.getReadableDatabase();

        //(cursor)
        sql="Select foto, nombre, apellido, edad, pasatiempo from Personas";
        Cursor c= db.rawQuery(sql,null);

        //Recorrido del cursor
        if (c.moveToFirst()){
            do{
                foto=c.getString(0);
                nombre=c.getString(1);
                apellido=c.getString(2);
                edad=Integer.parseInt(c.getString(3));
                pasatiempo=c.getString(4);

                Persona p = new Persona(foto,nombre,apellido,edad,pasatiempo);
                personas.add(p);

            }while(c.moveToNext());
        }

        //Cierro conexion
        db.close();

        //Retorno Personas
        return personas;

    }

}
