package vical.com.pe.myapp.startload;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import vical.com.pe.myapp.dao.ListaDao;
import vical.com.pe.myapp.dao.UserDao;
import vical.com.pe.myapp.dao.ValorDao;

/**
 * Created by Vical on 28/07/2015.
 */
public class Load {

    public static SQLiteDatabase db;

    public static void generateLoad (SQLiteDatabase db){
        Load.db = db;
        ContentValues user = new ContentValues();
        user.put(UserDao.Properties.Nombre.columnName, "Victor");
        user.put(UserDao.Properties.Paterno.columnName, "Rodriguez");
        user.put(UserDao.Properties.Materno.columnName, "Lozano");
        user.put(UserDao.Properties.Usuario.columnName, "vical");
        user.put(UserDao.Properties.Edad.columnName, 24);
        user.put(UserDao.Properties.Password.columnName, "123456");
        db.insert(UserDao.TABLENAME, "", user);

        ContentValues lista = new ContentValues();
        lista.put(ListaDao.Properties.Id.columnName, 1L);
        lista.put(ListaDao.Properties.Nomnbre.columnName, "Estados");
        lista.put(ListaDao.Properties.Codigo.columnName, "EST");
        lista.put(ListaDao.Properties.Descripcion.columnName, "Corresponde a los estado");
        lista.put(ListaDao.Properties.Valor.columnName, "EST");
        db.insert(ListaDao.TABLENAME, "", lista);

        ContentValues activo = new ContentValues();
        activo.put(ValorDao.Properties.Nomnbre.columnName, "Activo");
        activo.put(ValorDao.Properties.Codigo.columnName, "ACT");
        activo.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al estado activo");
        activo.put(ValorDao.Properties.Valor.columnName, "A");
        activo.put(ValorDao.Properties.ListaId.columnName, 1L);
        db.insert(ValorDao.TABLENAME, "", activo);

        ContentValues inactivo = new ContentValues();
        inactivo.put(ValorDao.Properties.Nomnbre.columnName, "Inactivo");
        inactivo.put(ValorDao.Properties.Codigo.columnName, "INA");
        inactivo.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al estado inactivo");
        inactivo.put(ValorDao.Properties.Valor.columnName, "I");
        inactivo.put(ValorDao.Properties.ListaId.columnName, 1L);
        db.insert(ValorDao.TABLENAME, "", inactivo);
    }
}
