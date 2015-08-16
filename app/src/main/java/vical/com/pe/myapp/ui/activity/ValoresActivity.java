package vical.com.pe.myapp.ui.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import vical.com.pe.myapp.R;
import vical.com.pe.myapp.entity.Valor;
import vical.com.pe.myapp.service.IConfiguracion;
import vical.com.pe.myapp.service.impl.ConfiguracionImpl;
import vical.com.pe.myapp.ui.adapter.ValorAdapter;


public class ValoresActivity extends ListActivity {

    private List<Valor> valores;
    private ValorAdapter valorAdapter;
    private IConfiguracion iConfiguracion = new ConfiguracionImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);
        Intent intent = getIntent();
        valores = iConfiguracion.listarValores(intent.getStringExtra(LocalidadActivity.CODIGO_LISTA));
        valorAdapter = new ValorAdapter(this, R.layout.layout_lista, valores);
        setListAdapter(valorAdapter);
    }
}
