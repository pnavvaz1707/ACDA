package Trimestre1.ExamenesAntiguos.ExamenACDA2122;

import java.io.Serializable;

public class Titulares implements Serializable {
    private int codigo;
    private String nombre;
    private String autor;
    private String anriguedad;
    private int hermandad;

    public Titulares(int codigo, String nombre, String autor, String anriguedad, int hermandad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.anriguedad = anriguedad;
        this.hermandad = hermandad;
    }
}
