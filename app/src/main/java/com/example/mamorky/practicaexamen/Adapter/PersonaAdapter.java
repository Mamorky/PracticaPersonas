package com.example.mamorky.practicaexamen.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mamorky.practicaexamen.data.pojo.Persona;
import com.example.mamorky.practicaexamen.R;

import java.util.ArrayList;

/**
 * Created by mamorky on 7/12/17.
 */

//**
// 1.- Heredamos de la clase ArrayAdapter
// */
public class PersonaAdapter extends ArrayAdapter<Persona> {

    //2.- Creamos el constructor que recibe un contexto
    public PersonaAdapter(@NonNull Context context) {

        //3.- Llamamos al super que recibira el contexto,la vista que vamos que infla y la lista de objetos
        super(context, R.layout.item_persona, new ArrayList<Persona>());
    }

    //3.- Creamos una clase donde tendremos todos los elemenos de la vista infladores
    private class PersonaHolder{
        public TextView txvNombre;
        public TextView txvApellido;
    }

    //4.- Sobreescribimos el método qetView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //5.- Es la vista que inflamosss
        View viewRoot = convertView;

        //6.- Creamos un objeto holder
        PersonaHolder personaHolder;

        //7.1 Si es null
        if(viewRoot == null){

            //7.1.1 Inflamos el layout viewRoot con la vista infladora
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewRoot = inflater.inflate(R.layout.item_persona,null);

            //7.1.2 Inicializamos el Holder
            personaHolder = new PersonaHolder();

            //7.1.3 Buscamos los elementos del viewRoot y los asignamos a los del holder
            personaHolder.txvNombre = (TextView)viewRoot.findViewById(R.id.txvNombre);
            personaHolder.txvApellido = (TextView)viewRoot.findViewById(R.id.txvApellido);

            //7.1.4 Asignamos el tag que será el holder
            viewRoot.setTag(personaHolder);
        }
        else
            //7.2 Si no es null cogemos el personaHolder ya creado y lo aprobechamos
            personaHolder = (PersonaHolder)viewRoot.getTag();

        //8 Añadimos el contenido al holder usando la posicion pasada el el método con getItme()
        personaHolder.txvNombre.setText(getItem(position).getNombre());
        personaHolder.txvApellido.setText(getItem(position).getApellido());

        //9 Devolvemos la vista
        return viewRoot;
    }
}
