package com.example.mamorky.practicaexamen.persona;

import com.example.mamorky.practicaexamen.pojo.Persona;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/12/17.
 */

public interface ListPersonaPresenter {
    String TAG = "listPersonaPre";

    ArrayList<Persona> searchPersonas();
    ArrayList<Persona> searchPersonas(String opcion);
    Persona searchPersona(int pos);
    boolean delete(Persona persona);

    void showPersonas();
}
