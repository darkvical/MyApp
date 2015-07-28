package vical.com.pe.myapp.ui;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Vical on 27/07/2015.
 */
public class BaseActivity extends Activity {

    public void inicioActivity(Activity activityPadre, Activity activityHija){
        Intent intent = new Intent(activityPadre, activityHija.getClass());
        startActivity(intent);
    }
}
