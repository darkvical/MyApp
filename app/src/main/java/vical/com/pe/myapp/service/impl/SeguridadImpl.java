package vical.com.pe.myapp.service.impl;

import android.app.Activity;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import vical.com.pe.myapp.dao.DaoSession;
import vical.com.pe.myapp.dao.UserDao;
import vical.com.pe.myapp.entity.User;
import vical.com.pe.myapp.service.ISeguridad;
import vical.com.pe.myapp.util.Connection;

/**
 * Created by Vical on 27/07/2015.
 */
public class SeguridadImpl implements ISeguridad {

    private UserDao userDao;
    @Override
    public List<User> listarUsuario(Activity activity) {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(activity, UserDao.TABLENAME);
        userDao = daoSession.getUserDao();
        QueryBuilder query = userDao.queryBuilder();
        List<User> users = query.list();
        return users;
    }

    @Override
    public User obtenerUsuario(String usuario, String password, Activity activity) {
        Connection conn = new Connection();
        DaoSession daoSession = conn.createConnection(activity, UserDao.TABLENAME);
        userDao = daoSession.getUserDao();
        QueryBuilder query = userDao.queryBuilder();
        query.and(UserDao.Properties.Nombre.eq(usuario), UserDao.Properties.Password.eq(password));
        List<User> users = query.list();
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }
}
