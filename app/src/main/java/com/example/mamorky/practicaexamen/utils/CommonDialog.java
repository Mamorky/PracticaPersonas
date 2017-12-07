package com.example.mamorky.practicaexamen.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mamorky.practicaexamen.Pojo.Persona;
import com.example.mamorky.practicaexamen.R;
import com.example.mamorky.practicaexamen.persona.ListPersonaPresenter;

/**
 * Created by mamorky on 7/12/17.
 */

public class CommonDialog {
    public static final String MESSAGE = "message";
    public static final String TITLE = "title";
    public static final String PERSONA = "persona";

    public static final String DELETE = "delete";

    public static Dialog ShowCommonDialog(Bundle bundle, final Context context, final ListPersonaPresenter presenter, String opcion){
        String message = bundle.getString(MESSAGE);
        String title = bundle.getString(TITLE);
        final Persona persona = (Persona) bundle.getParcelable(PERSONA);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if(opcion == DELETE){
            builder.setMessage(message);
            builder.setTitle(title);
            builder.setPositiveButton(R.string.btn_delete, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(presenter.delete(persona)){
                        Toast.makeText(context,"Se borro correctamente a: "+persona.getNombre(),Toast.LENGTH_LONG).show();
                        presenter.showPersonas();
                    }
                    else
                        Toast.makeText(context,"No se pudo borrar a: "+persona.getNombre(),Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }

        return builder.create();
    }
}
