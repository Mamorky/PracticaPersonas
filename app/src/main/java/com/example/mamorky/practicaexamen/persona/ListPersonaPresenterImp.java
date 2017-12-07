package com.example.mamorky.practicaexamen.persona;

import com.example.mamorky.practicaexamen.Pojo.Persona;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/12/17.
 */

public class ListPersonaPresenterImp implements ListPersonaPresenter{
    ListPersonaActivity view;
    ListPersonaInteractor interactor;

    public ListPersonaPresenterImp(ListPersonaActivity view){
        this.view = view;
        interactor = new ListPersonaInteractorImp(this);
    }
    @Override
    public ArrayList<Persona> searchPersonas() {
        return interactor.searchPersonas();
    }

    @Override
    public ArrayList<Persona> searchPersonas(String opcion) {
        return interactor.searchPersonas(opcion);
    }

    @Override
    public Persona searchPersona(int pos) {
        return interactor.searchPersona(pos);
    }

    @Override
    public boolean delete(Persona persona) {
        return interactor.delete(persona);
    }

    @Override
    public void showPersonas() {
        view.showPersonas();
    }
}
