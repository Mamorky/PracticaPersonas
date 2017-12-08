package com.example.mamorky.practicaexamen.addPersona;

/**
 * Created by mamorky on 7/12/17.
 */

public interface AddPersonaInteractor {
    void validatePersona(String nombre, String apellido,onValidateFinish onValidateFinish);
    boolean editPersona(String apellido,String nombre,onValidateFinish onValidateFinish);
    interface onValidateFinish{
        void onNombreError();
        void onApellidoError();
        void onSuccess();
    }
}
