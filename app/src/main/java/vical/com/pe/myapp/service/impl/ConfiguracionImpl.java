package vical.com.pe.myapp.service.impl;

import android.app.Activity;

import java.util.List;

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

    @Override
    public List<Lista> listarLista(Activity activity) {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(activity, ListaDao.TABLENAME);
        listaDao = daoSession.getListaDao();
        return listaDao.loadAll();
    }

    @Override
    public List<Valor> listarValores(Activity activity, String codigoLista) {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(activity, ValorDao.TABLENAME);
        valorDao = daoSession.getValorDao();
        List<Valor> valores2 = valorDao.loadAll();
        QueryBuilder<Valor> query = valorDao.queryBuilder();
        query.join(Lista.class, ValorDao.Properties.ListaId);
        query.where(ListaDao.Properties.Codigo.eq(codigoLista));
        List<Valor> valores = query.list();

        return valores;
    }
}
