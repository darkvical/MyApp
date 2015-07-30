package vical.com.pe.myapp.util;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import vical.com.pe.myapp.dao.DaoMaster;
import vical.com.pe.myapp.dao.DaoSession;

/**
 * Created by Vical on 28/07/2015.
 */
public class Connection {
    public DaoSession daoSession;
    public DaoMaster daoMaster;
    private SQLiteDatabase db;

    public Connection() {

    }

    public DaoSession createConnection(Activity activity, String nameTable){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(activity, nameTable+"-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
