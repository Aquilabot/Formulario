package com.example.formulario;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String fecha;
    private String telefono;
    private String correo;
    private String descripcion;

    Contacto(){
        this.nombre="";
        this.fecha="";
        this.telefono="";
        this.correo="";
        this.descripcion="";
    }

    Contacto(String nombre, String fecha ,String telefono, String correo, String descripcion){
        this.nombre=nombre;
        this.fecha=fecha;
        this.telefono=telefono;
        this.correo=correo;
        this.descripcion=descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) { this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
