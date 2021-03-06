package vical.com.pe.myapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vical.com.pe.myapp.R;
import vical.com.pe.myapp.entity.Lista;

/**
 * Created by Vical on 28/07/2015.
 */
public class ListaAdapter extends ArrayAdapter<Lista> {

    private List<Lista> listas;
    private Activity context;
    private int layoutMode;


    public ListaAdapter(Activity context, int layoutMode, List<Lista> listas) {
        super(context, layoutMode, listas);
        this.listas = listas;
        this.context = context;
        this.layoutMode = layoutMode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutMode, null);
        Lista lista = listas.get(position);

        TextView textNombre = (TextView) convertView.findViewById(R.id.textNombre);
        TextView textDescripcion = (TextView) convertView.findViewById(R.id.textDescripcion);
        TextView textValor = (TextView) convertView.findViewById(R.id.textValor);

        textNombre.setText(lista.getNomnbre());
        textDescripcion.setText(lista.getDescripcion());
        textValor.setText(lista.getValor());

        return convertView;
    }
}
