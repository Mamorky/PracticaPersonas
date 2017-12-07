package com.example.mamorky.practicaexamen.addPersona;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mamorky.practicaexamen.R;
import com.example.mamorky.practicaexamen.persona.ListPersonaActivityImp;

public class AddPersonaViewImp extends AppCompatActivity implements AddPersonaView{

    FloatingActionButton fab;
    AddPersonaPresenter presenter;

    EditText edtNombre,edtApellido;
    TextInputLayout tilNombre,tilApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);

        edtNombre = (EditText)findViewById(R.id.edt_persona_nombre);
        edtApellido = (EditText)findViewById(R.id.edt_persona_apellido);
        tilNombre = (TextInputLayout)findViewById(R.id.til_persona_nombre);
        tilApellido = (TextInputLayout)findViewById(R.id.til_persona_apellido);

        presenter = new AddPersonaPresenterImp(this);

        fab = (FloatingActionButton)findViewById(R.id.fab_personaAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validatePersona(edtNombre.getText().toString(),edtApellido.getText().toString());
            }
        });
    }

    @Override
    public void setOnNameError() {
        tilNombre.setError("Nombre no válido");
    }

    @Override
    public void setOnApellidoError() {
        tilApellido.setError("Apellido no válido");
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(getApplicationContext(), ListPersonaActivityImp.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ListPersonaActivityImp.class);
        startActivity(intent);
        finish();
    }
}
