package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ConfigGreenDao {
    public static void main(String[] args) throws Exception{
        Schema schema = new Schema(1, "vical.com.pe.myapp.entity");
        schema.setDefaultJavaPackageDao("vical.com.pe.myapp.dao");
        addUser(schema);
        new DaoGenerator().generateAll(schema,"D:\\Proyectos\\Android\\MyApp\\app\\src\\main\\java");
    }

    private static void addUser(Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty().autoincrement();
        user.addStringProperty("Nombre");
        user.addStringProperty("Paterno");
        user.addStringProperty("Materno");
        user.addIntProperty("Edad");
        user.addStringProperty("Usuario");
        user.addStringProperty("Password");
    }
}
