package vical.com.pe.myapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import vical.com.pe.myapp.R;
import vical.com.pe.myapp.entity.Lista;
import vical.com.pe.myapp.entity.User;
import vical.com.pe.myapp.service.IConfiguracion;
import vical.com.pe.myapp.service.ISeguridad;
import vical.com.pe.myapp.service.impl.ConfiguracionImpl;
import vical.com.pe.myapp.service.impl.SeguridadImpl;
import vical.com.pe.myapp.ui.activity.BaseActivity;
import vical.com.pe.myapp.ui.activity.LocalidadActivity;


public class Principal extends BaseActivity {

    private EditText editUser;
    private EditText editPass;

    private Intent intent;
    private ISeguridad iSeguridad = new SeguridadImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editUser = (EditText) findViewById(R.id.editUser);
        editPass = (EditText) findViewById(R.id.editPassword);
    }

    public void login (View view){
        String usuario = editUser.getText().toString();
        String password = editPass.getText().toString();
        if(StringUtils.isNotEmpty(usuario) && StringUtils.isNotEmpty(password)){
            User user = iSeguridad.obtenerUsuario(usuario, password, this);
            if(user != null){
                inicioActivity(this, new LocalidadActivity());
            }else{
                Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe ingresar un usuario y contraseña correcto", Toast.LENGTH_SHORT).show();
        }
    }

    public void eventThird(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item_principal:
                Toast.makeText(this, "PRINCIPAL", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_registrar:
                Toast.makeText(this, "REGISTRAR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_buscar:
                Toast.makeText(this, "BUSCAR", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}
