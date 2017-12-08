package com.example.mamorky.practicaexamen.persona;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mamorky.practicaexamen.Adapter.PersonaAdapter;
import com.example.mamorky.practicaexamen.pojo.Persona;
import com.example.mamorky.practicaexamen.R;
import com.example.mamorky.practicaexamen.addPersona.AddPersonaViewImp;
import com.example.mamorky.practicaexamen.utils.AddEdit;
import com.example.mamorky.practicaexamen.utils.CommonDialog;

import java.util.ArrayList;

public class ListPersonaActivityImp extends AppCompatActivity implements ListPersonaActivity{

    private PersonaAdapter adapter;
    private ListView listView;
    private ArrayList<Persona> personas;
    private ListPersonaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listViewPersonas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), AddPersonaViewImp.class);
                startActivity(intent);
                finish();
            }
        });

        presenter = new ListPersonaPresenterImp(this);

        adapter = new PersonaAdapter(this);
        listView.setAdapter(adapter);
        showPersonas();





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("modo",AddEdit.EDIT_MODE);
                bundle.putParcelable("persona",(Persona)adapterView.getItemAtPosition(i));
                Intent intent = new Intent(getApplication(),AddPersonaViewImp.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        // Esto es necesario para que se muestre el menú contextual
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_ordenarPorNombre:
                showPersonas();
                break;
            case R.id.action_ordenarPorApellido:
                showPersonas("apellido");
                break;
            case R.id.action_ordenarPorId:
                showPersonas("id");
                break;
            default:
                showPersonas();
        }
        return super.onOptionsItemSelected(item);
    }

    //Crea el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Manetiene el super
        super.onCreateContextMenu(menu, v, menuInfo);

        //Establece un título
        menu.setHeaderTitle("Titulo");

        //Infla el menu
        getMenuInflater().inflate(R.menu.menu_opciones_item,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list_personas_delete:
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Bundle bundle = new Bundle();
                Persona personaDel = presenter.searchPersona(menuInfo.position);
                bundle.putString(CommonDialog.MESSAGE,"Desea eliminar a: "+personaDel.getNombre());
                bundle.putString(CommonDialog.TITLE,"Eliminar");
                bundle.putParcelable(CommonDialog.PERSONA,personaDel);
                Dialog dialog = CommonDialog.ShowCommonDialog(bundle,this,presenter,CommonDialog.DELETE);
                dialog.show();
                break;
            default:
                super.onContextItemSelected(item);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void showPersonas() {
        //El método addAll añade el número de datos pasados a un adapter
        adapter.clear();
        adapter.addAll(presenter.searchPersonas());
    }

    public void showPersonas(String opcion) {
        //El método addAll añade el número de datos pasados a un adapter
        adapter.clear();
        adapter.addAll(presenter.searchPersonas(opcion));
    }
}
