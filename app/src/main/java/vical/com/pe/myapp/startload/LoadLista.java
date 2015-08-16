package vical.com.pe.myapp.startload;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import vical.com.pe.myapp.dao.ListaDao;
import vical.com.pe.myapp.dao.ValorDao;
import vical.com.pe.myapp.entity.Lista;
import vical.com.pe.myapp.service.IConfiguracion;
import vical.com.pe.myapp.service.impl.ConfiguracionImpl;

/**
 * Created by Vical on 29/07/2015.
 */
public class LoadLista {

    public static SQLiteDatabase db;

    public static void generateLista(SQLiteDatabase db){
        ContentValues lista = new ContentValues();
//        lista.put(ListaDao.Properties.Id.columnName, 1L);
        lista.put(ListaDao.Properties.Nomnbre.columnName, "Estados");
        lista.put(ListaDao.Properties.Codigo.columnName, "EST");
        lista.put(ListaDao.Properties.Descripcion.columnName, "Corresponde a los estado");
        lista.put(ListaDao.Properties.Valor.columnName, "EST");
        Long idEstadoLista = db.insert(ListaDao.TABLENAME, "", lista);

        lista = new ContentValues();
//        lista.put(ListaDao.Properties.Id.columnName, 2L);
        lista.put(ListaDao.Properties.Nomnbre.columnName, "Documento");
        lista.put(ListaDao.Properties.Codigo.columnName, "DOI");
        lista.put(ListaDao.Properties.Descripcion.columnName, "Corresponde a los documentos");
        lista.put(ListaDao.Properties.Valor.columnName, "DOI");
        Long idDocumentoLista = db.insert(ListaDao.TABLENAME, "", lista);

        ContentValues activo = new ContentValues();
        activo.put(ValorDao.Properties.Nomnbre.columnName, "Activo");
        activo.put(ValorDao.Properties.Codigo.columnName, "ACT");
        activo.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al estado activo");
        activo.put(ValorDao.Properties.Valor.columnName, "A");
        activo.put(ValorDao.Properties.ListaId.columnName, idEstadoLista);
        db.insert(ValorDao.TABLENAME, "", activo);

        ContentValues inactivo = new ContentValues();
        inactivo.put(ValorDao.Properties.Nomnbre.columnName, "Inactivo");
        inactivo.put(ValorDao.Properties.Codigo.columnName, "INA");
        inactivo.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al estado inactivo");
        inactivo.put(ValorDao.Properties.Valor.columnName, "I");
        inactivo.put(ValorDao.Properties.ListaId.columnName, idEstadoLista);
        db.insert(ValorDao.TABLENAME, "", inactivo);

        ContentValues dni = new ContentValues();
        dni.put(ValorDao.Properties.Nomnbre.columnName, "Documento nacional de identidad");
        dni.put(ValorDao.Properties.Codigo.columnName, "DNI");
        dni.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al documento DNI");
        dni.put(ValorDao.Properties.Valor.columnName, "L");
        dni.put(ValorDao.Properties.ListaId.columnName, idDocumentoLista);
        db.insert(ValorDao.TABLENAME, "", dni);

        ContentValues ruc = new ContentValues();
        ruc.put(ValorDao.Properties.Nomnbre.columnName, "R.U.C");
        ruc.put(ValorDao.Properties.Codigo.columnName, "RUC");
        ruc.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al documento RUC");
        ruc.put(ValorDao.Properties.Valor.columnName, "R");
        ruc.put(ValorDao.Properties.ListaId.columnName, idDocumentoLista);
        db.insert(ValorDao.TABLENAME, "", ruc);

        ContentValues extranjeria = new ContentValues();
        extranjeria.put(ValorDao.Properties.Nomnbre.columnName, "Extranjero");
        extranjeria.put(ValorDao.Properties.Codigo.columnName, "EXT");
        extranjeria.put(ValorDao.Properties.Descripcion.columnName, "Corresponde al documento EXT");
        extranjeria.put(ValorDao.Properties.Valor.columnName, "E");
        extranjeria.put(ValorDao.Properties.ListaId.columnName, idDocumentoLista);
        db.insert(ValorDao.TABLENAME, "", extranjeria);
    }
}
