package vical.com.pe.myapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import vical.com.pe.myapp.entity.Lista;

/**
 * Created by Vical on 28/07/2015.
 */
public class ListaAdapter extends ArrayAdapter<Lista> {

    private List<Lista> listas;
    private Activity context;
//    private


    public ListaAdapter(Context context, int resource, List<Lista> objects, List<Lista> listas, Activity context1) {
        super(context, resource, objects);
        this.listas = listas;
        this.context = context1;
    }
}
