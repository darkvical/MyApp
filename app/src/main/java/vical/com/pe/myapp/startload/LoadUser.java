package vical.com.pe.myapp.startload;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import vical.com.pe.myapp.dao.ListaDao;
import vical.com.pe.myapp.dao.UserDao;

/**
 * Created by Vical on 28/07/2015.
 */
public class LoadUser {

    public static SQLiteDatabase db;

    public static void generateLoad (SQLiteDatabase db){
        LoadUser.db = db;
        ContentValues user = new ContentValues();
        user.put(UserDao.Properties.Nombre.columnName, "Victor");
        user.put(UserDao.Properties.Paterno.columnName, "Rodriguez");
        user.put(UserDao.Properties.Materno.columnName, "Lozano");
        user.put(UserDao.Properties.Usuario.columnName, "vical");
        user.put(UserDao.Properties.Edad.columnName, 24);
        user.put(UserDao.Properties.Password.columnName, "123456");
        db.insert(UserDao.TABLENAME, "", user);
    }
}
