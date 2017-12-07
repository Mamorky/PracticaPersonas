package com.example.mamorky.practicaexamen.Respository;

import com.example.mamorky.practicaexamen.Pojo.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mamorky on 7/12/17.
 */

public class PersonasRepository {

    //1.- Crear la lista de personas
    private ArrayList<Persona> personas;

    //2.- Crear la instancia singleton de la clase
    private static PersonasRepository instance;

    //3.- Crear construcctor
    private PersonasRepository(){
        personas = new ArrayList<Persona>();
        inicialize();
    }

    //4.- Dar memoria al construcctor o simplemente devolverlo. ¡¡¡>>>> Unico método estático <<<<<!!!
    public static PersonasRepository getInstance(){
        if(instance == null)
            instance = new PersonasRepository();

        return instance;
    }

    //5.- Inicializar (Esto es opcional)
    private void inicialize(){
        for (int i = 0; i < 25; i++) {
            addPersona(new Persona(i,"pepe","bartoleño"));
            addPersona(new Persona(i,"juea","carrisso"));
            addPersona(new Persona(i,"caramelo","menta"));
        }
    }

    //6.- Método añadir Personas
    public void addPersona(Persona persona){
        personas.add(persona);
    }

    public Persona getPersona(int pos){
        return personas.get(pos);
    }

    public boolean existsPersona(Persona persona){
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getApellido().equals(persona.getApellido()))
                return true;
        }
        return false;
    }

    public boolean deletePersona(Persona persona){
        return personas.remove(persona);
    }

    public int getLastId(){
        int maxId = 0;
        for(Persona tmp:personas){
            if(tmp.getId() >= maxId)
                maxId = tmp.getId();
        }

        return maxId;
    }

    //7.- Método obtener personas
    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    public ArrayList<Persona> getPersonas(String orden){

        //Es necesario utilizar Collietion.sort para ordenar
        if(orden == "nombre")
            Collections.sort(personas);
        else if(orden == "id"){
            Collections.sort(personas,new CompareById());
        }
        else if(orden == "apellido"){
            Collections.sort(personas,new CompareByApellido());
        }
        return personas;
    }
}


// Para poder ordenar tenemos que implementar la interfaz comparartor en clases nuevas

class CompareByApellido implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getApellido().compareTo(o2.getApellido());
    }
}

class CompareById implements Comparator<Persona>{
    @Override
    public int compare(Persona o1, Persona o2) {
        if(o1.getId()<o2.getId())
            return -1;
        if(o1.getId()>o2.getId())
            return 1;
        else
            return 0;
    }
}
