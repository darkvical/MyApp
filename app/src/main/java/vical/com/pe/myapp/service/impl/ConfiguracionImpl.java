package vical.com.pe.myapp.service.impl;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.Join;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import vical.com.pe.myapp.dao.DaoSession;
import vical.com.pe.myapp.dao.ListaDao;
import vical.com.pe.myapp.dao.ValorDao;
import vical.com.pe.myapp.entity.Lista;
import vical.com.pe.myapp.entity.Valor;
import vical.com.pe.myapp.service.IConfiguracion;
import vical.com.pe.myapp.util.Connection;

/**
 * Created by Vical on 28/07/2015.
 */
public class ConfiguracionImpl implements IConfiguracion{

    private ListaDao listaDao;
    private ValorDao valorDao;
    private Context context;

    public ConfiguracionImpl(final Context context){
        this.context = context;
    }

    @Override
    public List<Lista> listarLista() {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(context, ListaDao.TABLENAME);
        listaDao = daoSession.getListaDao();
        return listaDao.loadAll();
    }

    public Lista obtenerLista (String codigoLista){
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(context, ListaDao.TABLENAME);
        listaDao = daoSession.getListaDao();
        QueryBuilder<Lista> query = listaDao.queryBuilder();
        query.where(ListaDao.Properties.Codigo.eq(codigoLista));
        List<Lista> listas = query.list();
        if(listas.isEmpty()){
            return null;
        }
        return listas.get(0);
    }

    @Override
    public List<Valor> listarValores(String codigoLista) {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(this.context, ValorDao.TABLENAME);
        valorDao = daoSession.getValorDao();
        QueryBuilder<Valor> query = valorDao.queryBuilder();
        Join lista = query.join(ValorDao.Properties.ListaId, Lista.class);
        lista.where(ListaDao.Properties.Codigo.eq(codigoLista));
        List<Valor> valores = query.list();
        return valores;
    }
}