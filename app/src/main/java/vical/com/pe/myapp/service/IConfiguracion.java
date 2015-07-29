package vical.com.pe.myapp.service;

import android.app.Activity;

import java.util.List;

import vical.com.pe.myapp.entity.Lista;
import vical.com.pe.myapp.entity.Valor;

/**
 * Created by Vical on 28/07/2015.
 */
public interface IConfiguracion {

    List<Lista> listarLista(Activity activity);

    List<Valor> listarValores(Activity activity, String codigoLista);
}
