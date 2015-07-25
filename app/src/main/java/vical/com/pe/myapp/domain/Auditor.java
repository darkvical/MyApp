package vical.com.pe.myapp.domain;

import java.util.Date;

/**
 * Created by Vical on 25/07/2015.
 */
public class Auditor {
    private Usuario creador;
    private Date creacion;
    private Usuario editor;
    private Date edicion;

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Usuario getEditor() {
        return editor;
    }

    public void setEditor(Usuario editor) {
        this.editor = editor;
    }

    public Date getEdicion() {
        return edicion;
    }

    public void setEdicion(Date edicion) {
        this.edicion = edicion;
    }
}
