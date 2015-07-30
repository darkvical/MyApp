package vical.com.pe.myapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vical.com.pe.myapp.R;
import vical.com.pe.myapp.entity.Valor;

/**
 * Created by Vical on 29/07/2015.
 */
public class ValorAdapter extends ArrayAdapter<Valor> {

    private List<Valor> valores;
    private Activity context;
    private int layoutMode;

    public ValorAdapter(Activity context, int layoutMode, List<Valor> valores) {
        super(context, layoutMode, valores);
        this.valores = valores;
        this.context = context;
        this.layoutMode = layoutMode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutMode, null);
        Valor valor = valores.get(position);

        TextView textNombre = (TextView) convertView.findViewById(R.id.textNombre);
        TextView textDescripcion = (TextView) convertView.findViewById(R.id.textDescripcion);
        TextView textValor = (TextView) convertView.findViewById(R.id.textValor);

        textNombre.setText(valor.getNomnbre());
        textDescripcion.setText(valor.getDescripcion());
        textValor.setText(valor.getValor());
        return convertView;
    }
}
