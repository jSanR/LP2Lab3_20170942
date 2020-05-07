/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.model;

import java.util.Date;

/**
 *
 * @author Jesus
 */
public class Congreso {
    private int id;
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String pais;
    private boolean activo;
    
    public Congreso(){
    }
    
    public Congreso(String nombre, Date fecha_inicio, Date fecha_fin, String pais, boolean activo){
        this.nombre=nombre;
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
        this.pais=pais;
        this.activo=activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String mostrarDatos(){
        return id + " - " + nombre + " - " + fecha_inicio + " - " + fecha_fin + " - " + pais;
    }
}
