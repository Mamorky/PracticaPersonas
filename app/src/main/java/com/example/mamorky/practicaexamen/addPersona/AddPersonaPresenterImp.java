package com.example.mamorky.practicaexamen.addPersona;

/**
 * Created by mamorky on 7/12/17.
 */

public class AddPersonaPresenterImp implements AddPersonaPresenter,AddPersonaInteractor.onValidateFinish{
    AddPersonaView view;
    AddPersonaInteractor interactor;

    public AddPersonaPresenterImp(AddPersonaView view){
        this.view = view;
        this.interactor = new AddPersonaInteractorImp(this);
    }

    @Override
    public void validatePersona(String nombre, String apellido) {
        interactor.validatePersona(nombre,apellido,this);
    }


    @Override
    public void onNombreError() {
        view.setOnNameError();
    }

    @Override
    public void onApellidoError() {
        view.setOnApellidoError();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }
}
