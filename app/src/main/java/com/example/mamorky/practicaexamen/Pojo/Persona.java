package com.example.mamorky.practicaexamen.Pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by mamorky on 7/12/17.
 */

public class Persona implements Parcelable,Comparable<Persona>{

    //1.- Crear Campos

    private int id;
    private String nombre;
    private String apellido;

    //2.- Constructor

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //3.- Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    //4.- Implementación de parcelable

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(nombre);
        parcel.writeString(apellido);
    }

    protected Persona(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
    }

    @Override
    public int compareTo(@NonNull Persona o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
