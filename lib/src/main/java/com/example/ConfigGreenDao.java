package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class ConfigGreenDao {

    private static Entity user;
    private static Entity lista;
    private static Entity valor;

    public static void main(String[] args) throws Exception{
        Schema schema = new Schema(4, "vical.com.pe.myapp.entity");
        schema.setDefaultJavaPackageDao("vical.com.pe.myapp.dao");
        addUser(schema);
        addLista(schema);
        addValor(schema);
        new DaoGenerator().generateAll(schema,"D:\\Proyectos\\Android\\MyApp\\app\\src\\main\\java");
    }

    private static Entity addValor(Schema schema) {
        valor = schema.addEntity("Valor");
        Property listaIdProperty = valor.addLongProperty("listaId").getProperty();
        valor.addIdProperty().autoincrement();
        valor.addStringProperty("Codigo").notNull();
        valor.addStringProperty("Nomnbre");
        valor.addStringProperty("Descripcion");
        valor.addStringProperty("Valor");
        valor.addToOne(lista, listaIdProperty, "lista");
        return valor;
    }

    private static Entity addLista(Schema schema) {
        lista = schema.addEntity("Lista");
        lista.addIdProperty().autoincrement();
        lista.addStringProperty("Codigo").notNull();
        lista.addStringProperty("Nomnbre");
        lista.addStringProperty("Descripcion");
        lista.addStringProperty("Valor");
        return lista;
    }

    private static Entity addUser(Schema schema) {
        user = schema.addEntity("User");
        user.addIdProperty().autoincrement();
        user.addStringProperty("Nombre");
        user.addStringProperty("Paterno");
        user.addStringProperty("Materno");
        user.addIntProperty("Edad");
        user.addStringProperty("Usuario");
        user.addStringProperty("Password");
        return user;
    }
}
