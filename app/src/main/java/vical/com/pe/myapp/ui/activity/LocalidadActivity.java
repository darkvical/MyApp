package vical.com.pe.myapp.ui.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import vical.com.pe.myapp.R;
import vical.com.pe.myapp.entity.Lista;
import vical.com.pe.myapp.service.IConfiguracion;
import vical.com.pe.myapp.service.impl.ConfiguracionImpl;
import vical.com.pe.myapp.ui.Principal;
import vical.com.pe.myapp.ui.adapter.ListaAdapter;


public class LocalidadActivity extends ListActivity {

    private ListView listView;
    private ListaAdapter listaAdapter;
    private IConfiguracion iConfiguracion = new ConfiguracionImpl(this);
    private List<Lista> listas;
    public static final String CODIGO_LISTA = "CODIGO_LISTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidades);
        listView = getListView();
        listas = iConfiguracion.listarLista();
        listaAdapter = new ListaAdapter(this, R.layout.layout_lista, listas);
        setListAdapter(listaAdapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        Lista listaSeleccion = listas.get(position);
        Intent intent = new Intent(this, ValoresActivity.class);
        intent.putExtra(CODIGO_LISTA, listaSeleccion.getCodigo());
        startActivity(intent);
    }
}
