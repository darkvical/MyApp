package vical.com.pe.myapp.service;

import android.app.Activity;

import java.util.List;

import vical.com.pe.myapp.entity.User;

/**
 * Created by Vical on 27/07/2015.
 */
public interface ISeguridad {
    List<User> listarUsuario (Activity activity);

    User obtenerUsuario(String usuario, String password, Activity activity);
}
