package com.example.mamorky.practicaexamen.addPersona;

import com.example.mamorky.practicaexamen.pojo.Persona;
import com.example.mamorky.practicaexamen.Respository.PersonasRepository;

/**
 * Created by mamorky on 7/12/17.
 */

public class AddPersonaInteractorImp implements AddPersonaInteractor{

    AddPersonaPresenter presenter;

    public AddPersonaInteractorImp(AddPersonaPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void validatePersona(String nombre, String apellido,AddPersonaInteractor.onValidateFinish onValidateFinish) {
        Persona personaTmp = new Persona(PersonasRepository.getInstance().getLastId()+1,nombre,apellido);
        if(nombre.isEmpty())
            onValidateFinish.onNombreError();
        else if(apellido.isEmpty())
            onValidateFinish.onApellidoError();
        else if(PersonasRepository.getInstance().existsPersona(personaTmp))
        {
            onValidateFinish.onApellidoError();
        }
        else{
            PersonasRepository.getInstance().addPersona(personaTmp);
            onValidateFinish.onSuccess();
        }
    }

    @Override
    public boolean editPersona(String apellido, String nombre,onValidateFinish onValidateFinish) {
        if(nombre.isEmpty())
            onValidateFinish.onNombreError();
        else{
            PersonasRepository.getInstance().editPersona(apellido,nombre);
            onValidateFinish.onSuccess();
            return true;
        }
        return false;
    }
}
