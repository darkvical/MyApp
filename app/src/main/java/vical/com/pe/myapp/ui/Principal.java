package vical.com.pe.myapp.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import vical.com.pe.myapp.R;


public class Principal extends ActionBarActivity {

    private EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editMessage = (EditText)findViewById(R.id.editMensaje);
    }

    public void eventAceptar(View view){
        String message = editMessage.getText().toString();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
