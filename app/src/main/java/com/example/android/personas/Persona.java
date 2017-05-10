package com.example.android.personas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by android on 04/04/2017.
 */

public class Persona {
    private String foto;
    private String nombre;
    private String apellido;
    private int edad;
    private String pasatiempos;

    public Persona(String nombre, String apellido, int edad, String pasatiempos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempos = pasatiempos;
    }

    public Persona(String foto, String nombre, String apellido, int edad, String pasatiempos) {
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempos = pasatiempos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getPasatiempos() {
        return pasatiempos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPasatiempos(String pasatiempos) {
        this.pasatiempos = pasatiempos;
    }

    public void guardar(Context contexto){

        //Declarar variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion (en modo de escritura)
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null,1);
        db = aux.getWritableDatabase();

        //Insercion forma 1
        sql="INSERT INTO Personas values('"+this.getFoto()+"','"+this.getNombre()+"','"+this.getApellido()+"','"+this.getEdad()+"','"+this.getPasatiempos()+"')";
        db.execSQL(sql);

        /*Insercion forma 2
        ContentValues nuevaPersona = new ContentValues();
        nuevaPersona.put("foto",this.getFoto());
        nuevaPersona.put("nombre",this.getNombre());
        nuevaPersona.put("apellido",this.getApellido());
        nuevaPersona.put("edad",String.valueOf(this.getEdad()));
        nuevaPersona.put("pasatiempo",this.getPasatiempos());

        db.insert("Personas",null,nuevaPersona);*/

        db.close();

        //Datos.guardar(this);
    }
}
