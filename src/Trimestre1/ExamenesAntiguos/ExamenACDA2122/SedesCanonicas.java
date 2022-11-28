package Trimestre1.ExamenesAntiguos.ExamenACDA2122;

import java.io.Serializable;

public class SedesCanonicas implements Serializable {
    private int codigo;
    private String nombre;
    private String direccion;
    private String parroco;

    public SedesCanonicas(int codigo, String nombre, String direccion, String parroco) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.parroco = parroco;
    }
}
