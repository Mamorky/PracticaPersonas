package com.example.mamorky.practicaexamen.persona;

import com.example.mamorky.practicaexamen.data.pojo.Persona;
import com.example.mamorky.practicaexamen.data.Respository.PersonasRepository;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/12/17.
 */

public class ListPersonaInteractorImp implements ListPersonaInteractor{
    ListPersonaPresenter presenter;

    public ListPersonaInteractorImp(ListPersonaPresenterImp presenter){
        this.presenter = presenter;
    }

    @Override
    public ArrayList<Persona> searchPersonas() {
        return PersonasRepository.getInstance().getPersonas();
    }

    @Override
    public ArrayList<Persona> searchPersonas(String opcion) {
        return PersonasRepository.getInstance().getPersonas(opcion);
    }

    @Override
    public Persona searchPersona(int pos) {
        return PersonasRepository.getInstance().getPersona(pos);
    }

    @Override
    public boolean delete(Persona persona) {
        return PersonasRepository.getInstance().deletePersona(persona);
    }
}
